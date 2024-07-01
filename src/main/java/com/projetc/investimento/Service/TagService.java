package com.projetc.investimento.Service;

import com.projetc.investimento.Dao.TagDao;
import com.projetc.investimento.Enum.MessagesEnum;
import com.projetc.investimento.Exception.ExistException;
import com.projetc.investimento.Exception.NotFoundException;
import com.projetc.investimento.Gateway.BrapiGateway;
import com.projetc.investimento.Model.DTO.TagDTO;
import com.projetc.investimento.Model.Request.TagRequest;
import com.projetc.investimento.Gateway.GatewayRequest;
import com.projetc.investimento.Model.Response.TagResponse;
import com.projetc.investimento.Model.Tag;
import com.projetc.investimento.Utils.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TagService {

    private final BrapiGateway brapiGateway;
    private final TagDao tagDao;

    public Tag saveTag(TagRequest data){
        Boolean tagFind = tagDao.existsByTagName(data.tagName());

        if(tagFind.equals(Boolean.TRUE)){
            throw new ExistException(MessagesEnum.TAG_EXISTS.getDescricao());
        }

        Tag newTag = new Tag();
        TagDTO tagGateway = searchTagGateway(data.tagName());

        newTag.setName(tagGateway.getLongName());
        newTag.setTagName(tagGateway.getSymbol());
        newTag.setValorAtual(tagGateway.getRegularMarketPrice());
        newTag.setLogo(tagGateway.getLogourl());
        newTag.setDate(DataUtil.converteDateTimeToString(new Date()));

        tagDao.save(newTag);

        return newTag;

    }

    public TagResponse findTag(Long id, Boolean update){
        Tag tagFind = tagDao.findById(id).orElseThrow(() -> new NotFoundException(MessagesEnum.TAG_NOT_FOUND.getDescricao()));

        if(update.equals(Boolean.TRUE)){
            TagDTO tagGateway = searchTagGateway(tagFind.getTagName());

            tagFind.setValorAtual(tagGateway.getRegularMarketPrice());
            tagFind.setDate(DataUtil.converteDateTimeToString(new Date()));

            tagDao.save(tagFind);
        }

        return new TagResponse(tagFind.getName(), tagFind.getTagName(), tagFind.getLogo(),
                                                    tagFind.getValorAtual(), tagFind.getDate());
    }

    public void deleteTag(Long id){
        tagDao.findById(id)
                .map(tag -> {
                    tagDao.deleteById(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new NotFoundException(MessagesEnum.TAG_NOT_FOUND.getDescricao()));
    }

    private TagDTO searchTagGateway(String tag){
        ResponseEntity<GatewayRequest> resp = brapiGateway.findTag(tag);
        return Objects.requireNonNull(resp.getBody()).getResults().get(0);
    }

}
