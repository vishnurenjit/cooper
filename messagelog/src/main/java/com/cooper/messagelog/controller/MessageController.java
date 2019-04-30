package com.cooper.messagelog.controller;

import com.cooper.messagelog.BO.MessageBO;
import com.cooper.messagelog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/customer/{customer_id}/messagelog")
    public List<MessageBO> getMessages(@PathVariable("customer_id") long custId,
                                       @RequestParam("channel")String channel) {
        return messageService.getMessages(custId, channel);
    }

    @RequestMapping(value = "/asset/{asset_id}/{ver_num}/htmlstring")
    public String getAssetBody(@PathVariable("asset_id") String assetId, @PathVariable("ver_num")int verNum) {
        return messageService.getAssetBody(assetId, verNum);
    }

    @RequestMapping(value = "/messagelog/{rec_id}", method = RequestMethod.PUT)
    public boolean updateLog(@PathVariable("rec_id") long recId, @RequestParam("read") Boolean read,
                            @RequestParam("delete") Boolean delete) {
        return messageService.updateLog(recId, read, delete);
    }

}
