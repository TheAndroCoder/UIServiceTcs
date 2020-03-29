package com.tcs.controllers;
import com.tcs.models.Login;
import com.tcs.models.Response;
import com.tcs.models.Transaction;
import com.tcs.models.User;
import com.tcs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class RequestController {

    @Autowired
    private RestTemplate restTemplate;

    ///////////////////// PAGES /////////////////////
    @GetMapping(value="/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping(value="/register")
    public String registerPage(){
        return "register";
    }
    @GetMapping(value = "/statement")
    public String statementPage(){
        return "statement";
    }
    @GetMapping(value = "/transfer")
    public String transferPage(){return "fundtransfer";}
    @GetMapping(value = "/passbook")
    public String passbookPage(){return "passbook";}
    @GetMapping(value = "/admin-users")
    public String adminUsersPage(){
        return "admin-users";
    }
    @GetMapping(value = "/admin-transactions")
    public String adminTransactionsPage(){
        return "admin-transactions";
    }
    @GetMapping(value = "/admin-accounts")
    public String adminAccountsPage(){
        return "admin-accounts";
    }

    /******************** CALLING MICROSERVICES *********************/
    @PostMapping(value="/register",consumes = "application/json")
    public @ResponseBody Response register(@RequestBody  User user){
        //System.out.println("Email is "+user.getEmail());
        Response resp=restTemplate.postForObject("http://"+Constants.LOGIN_SERVICE +"/saverecord",user,Response.class);
        return resp;
    }

    @PostMapping(value = "/login")
    public @ResponseBody Response login(@RequestBody User user){
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForObject("http://"+Constants.LOGIN_SERVICE+"/login",user,Response.class);
    }

    @GetMapping(value = "/getSecurityQuestion")
    public @ResponseBody Response getSecurityQuestion(@RequestParam("email") String email){
        return restTemplate.getForObject("http://"+Constants.LOGIN_SERVICE+"/getSecurityQuestion?email="+email,Response.class);
    }

    @PostMapping(value = "/changepassword")
    public @ResponseBody Response changePassword(@RequestBody Login login){
        return restTemplate.postForObject("http://"+Constants.LOGIN_SERVICE+"/changepassword",login,Response.class);
    }

    @GetMapping(value = "/transactions")
    public @ResponseBody Response getTransactions(@RequestParam("userid")String userid){
        return restTemplate.getForObject("http://"+Constants.PASSBOOK_SERVICE+"/passbook?userid="+userid,Response.class);
    }

    @GetMapping(value = "/getaccount")
    public @ResponseBody Response getAccountForUserid(@RequestParam("userid")String userid){
        return restTemplate.getForObject("http://"+Constants.LOGIN_SERVICE+"/getaccount?userid="+userid,Response.class);
    }

    @PostMapping(value = "/fund-transfer")
    public @ResponseBody Response initiateFundTransfer(@RequestBody Transaction transaction){
        transaction.setModeofpayment("epayment");
        transaction.setUpdatetype("debit");
        System.out.println(transaction.toString());
        return restTemplate.postForObject("http://"+Constants.TRANSACTION_SERVICE+"/transaction",transaction,Response.class);
    }

    @GetMapping(value = "/all-users")
    public @ResponseBody Response getAllUsers(){
        return restTemplate.getForObject("http://"+Constants.LOGIN_SERVICE+"/getrecords",Response.class);
    }
    @GetMapping(value = "/all-transactions")
    public @ResponseBody Response getAllTransactions(){
        return restTemplate.getForObject("http://"+Constants.TRANSACTION_SERVICE+"/getTransaction",Response.class);
    }
    @GetMapping(value = "/getUserById")
    public @ResponseBody Response getUserById(@RequestParam("userid") String userid){
        return restTemplate.getForObject("http://"+Constants.LOGIN_SERVICE+"/getUserById?userid="+userid,Response.class);
    }
    @GetMapping(value = "/getAllAccounts")
    public @ResponseBody Response getAllAccounts(){
        return restTemplate.getForObject("http://"+Constants.LOGIN_SERVICE+"/getAllAccounts",Response.class);
    }
    @GetMapping(value = "/getAccountById")
    public @ResponseBody Response getAccountById(@RequestParam("accountid") String accountid){
        return restTemplate.getForObject("http://"+Constants.LOGIN_SERVICE+"/getAccountById?accountid="+accountid,Response.class);
    }
    @PostMapping(value = "/updateUser")
    public @ResponseBody Response updateUser(@RequestBody User user){
        System.out.println(user.toString());
        return restTemplate.postForObject("http://"+Constants.LOGIN_SERVICE+"/updateUser",user,Response.class);
        //return new Response(true,"Success");
    }
    @GetMapping(value = "/getTransactionById")
    public @ResponseBody Response getTransactionById(@RequestParam("transactionid") int id){
        return restTemplate.getForObject("http://"+Constants.TRANSACTION_SERVICE+"/getTransactionById?transactionid="+id,Response.class);
    }
}
