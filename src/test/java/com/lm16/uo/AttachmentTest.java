package com.lm16.uo;

import com.lm16.uo.bean.Attachment;
import org.junit.Test;

public class AttachmentTest extends BaseTest{

    @Test
    public void a(){
        Attachment attachment = new Attachment();

        attachment.setId("fasr2354hrt");
        attachment.setFileName("个人简历.doc");
        attachment.setUserId("dw2134dsf");

        attachmentService.save(attachment);

        logger.info("在 mongo 中存入了数据");
    }

}
