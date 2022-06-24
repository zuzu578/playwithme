package com.withgame.game.main.login.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;

import com.gargoylesoftware.htmlunit.html.HtmlElement;

import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Service
public class LoginService {

    public HashMap<String, Object> doLogin(String id, String password) {
        WebClient wc = new WebClient();
        String url = "https://account.bandainamcoid.com/login.html?client_id=nbgi_taiko&customize_id=&redirect_uri=https%3A%2F%2Fwww.bandainamcoid.com%2Fv2%2Foauth2%2Fauth%3Fback%3Dv3%26client_id%3Dnbgi_taiko%26scope%3DJpGroupAll%26redirect_uri%3Dhttps%253A%252F%252Fdonderhiroba.jp%252Flogin_process.php%253Finvite_code%253D%2526abs_back_url%253D%2526location_code%253D%26text%3D&prompt=login";
        wc.getOptions().setThrowExceptionOnScriptError(false);

        try {
            HtmlPage page = (HtmlPage) wc.getPage(url);
            HtmlInput userId = (HtmlInput) page.getElementByName("mail");
            HtmlInput userPassword = (HtmlInput) page.getElementByName("pass");

            wc.getOptions().setThrowExceptionOnScriptError(false);
            wc.getOptions().setUseInsecureSSL(true);

            wc.waitForBackgroundJavaScript(10000);

            userId.setValueAttribute("dlwnghks6821@naver.com");
            userPassword.setValueAttribute("lms3821su");

            HtmlElement loginBtn = page
                    .getFirstByXPath("//button[@class='btn _btn-size-50 _btn-yellow']");

            loginBtn.click();
            // 필수
            Thread.sleep(7000);

            HtmlPage page2 = wc.getPage("https://donderhiroba.jp/login_select.php");

            System.out.println(page2.asNormalizedText());
            // Thread.sleep(3500);
            HtmlAnchor button3 = page2.getAnchorByHref("javascript:void(0)");
            button3.click();

            HtmlPage page3 = wc.getPage("https://donderhiroba.jp/index.php");

            HtmlElement myDonImg = page3.getFirstByXPath("//div[@id='mydon_area']/div[3]/div[2]/img"); // 마이동
            HtmlElement nickName = page3.getFirstByXPath("/html/body/div[1]/div/div[3]/div[2]/div[1]");
            HtmlElement danwi = page3.getFirstByXPath("//div[@id='mydon_area']/div[2]/div[2]/img"); // 단위
            System.out.println("dan" + danwi);
            System.out.println("testsetstes" + nickName.asNormalizedText());

            HashMap<String, Object> userData = new HashMap<String, Object>();

            userData.put("mydon", myDonImg.toString());
            userData.put("dan", danwi.toString());
            userData.put("nickName", nickName.asNormalizedText());

            return userData;
        } catch (Exception e) {
            return null;
        }

    }

}
