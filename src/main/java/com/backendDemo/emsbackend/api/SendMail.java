package com.backendDemo.emsbackend.api;

import com.backendDemo.emsbackend.dto.MessageDto;
import com.backendDemo.emsbackend.entity.Department;
import com.backendDemo.emsbackend.entity.Employee;
import com.backendDemo.emsbackend.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SendMail {

    private static final String APPTOKEN = "cce222e8-ef15-43ae-ace3-fdcf4144690f";
    private static final String APPID = "f668dd56-db1b-4359-ad8f-ab303b09b732";

    private final MessageDto myBean;

    public SendMail(MessageDto myBean) {
        this.myBean = myBean;
    }

    public void employeeDepartment (Employee employee, Department department) {
        RestTemplate restTemplate = new RestTemplate();

//        MessageDto messageDto = new MessageDto();
//        messageDto.setMessage("Hello " + employee.getFirstName() + "\n\nYou have been assigned to " + department.getDepartmentName() + " department.");
//        messageDto.setSubject("Assigned Department");
//        messageDto.setRecipientEmail(employee.getEmail());
//        messageDto.setRecipientName(employee.getFirstName());
        myBean.setSubject("Assigned Department");
        myBean.setRecipientEmail(employee.getEmail());
        myBean.setRecipientName(employee.getFirstName());

        System.out.println(myBean.toString());

        String hash = Utilities.getHash(employee.getEmail()+APPTOKEN);

        HttpHeaders headers = new HttpHeaders();
        headers.set("requestKey", APPID);
        headers.set("hash", hash);

//        HttpEntity<MessageDto> httpEntity = new HttpEntity<>(messageDto, headers);
        HttpEntity<MessageDto> httpEntity = new HttpEntity<>(myBean, headers);


        String uri = "http://localhost:8080/api/message/send";

        ResponseEntity<String> result = restTemplate.postForEntity(uri, httpEntity, String.class);

    }


}
