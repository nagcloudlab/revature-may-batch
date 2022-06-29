package com.example.web;

import com.example.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    //@RequestMapping(method = RequestMethod.POST)
    // -or-
    @PostMapping
    public ModelAndView doTransfer(
            @RequestParam double amount,
            @RequestParam String sourceAccountNumber,
            @RequestParam String targetAccountNumber
    ) {
        ModelAndView mav = new ModelAndView();
        try {
            transferService.transfer(amount, sourceAccountNumber, targetAccountNumber);
            mav.addObject("message", "transfer successfully");
        } catch (Exception e) {
            mav.addObject("message", e.getMessage());
        }
        mav.setViewName("txr-status");
        return mav;
    }

}
