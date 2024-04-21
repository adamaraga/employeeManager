package com.backendDemo.emsbackend.api;

import com.backendDemo.emsbackend.dto.MessageDto;
import com.backendDemo.emsbackend.entity.Department;
import com.backendDemo.emsbackend.entity.Employee;
import com.backendDemo.emsbackend.util.Utilities;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SendMail {

    private static final String APPTOKEN = "cce222e8-ef15-43ae-ace3-fdcf4144690f";
    private static final String APPID = "f668dd56-db1b-4359-ad8f-ab303b09b732";


    public static void employeeDepartment (Employee employee, Department department) {
        RestTemplate restTemplate = new RestTemplate();

        MessageDto messageDto = new MessageDto();
        messageDto.setMessage("Hello " + employee.getFirstName() + "You have been assigned to " + department.getDepartmentName() + " department.");
        messageDto.setSubject("Assigned Department");
        messageDto.setRecipientEmail(employee.getEmail());
        messageDto.setRecipientName(employee.getFirstName());

        String hash = Utilities.getHash(employee.getEmail()+APPTOKEN);

        HttpHeaders headers = new HttpHeaders();
        headers.set("requestKey", APPID);
        headers.set("hash", hash);

        HttpEntity<MessageDto> httpEntity = new HttpEntity<>(messageDto, headers);

        String uri = "http://localhost:8080/api/message/send";

        ResponseEntity<String> result = restTemplate.postForEntity(uri, httpEntity, String.class);

    }


}
