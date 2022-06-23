package com.withgame.game.main.login.service;

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

    public String doLogin(String id, String password) {
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

            System.out.println(page.asXml());
            userId.setValueAttribute(id);
            userPassword.setValueAttribute(password);

            System.out
                    .println("입력한 id =>" + userId.getValueAttribute() + "입력한 pw =>" + userPassword.getValueAttribute());

            HtmlElement loginBtn = page
                    .getFirstByXPath("//button[@class='btn _btn-size-50 _btn-yellow']");

            // button2.removeAttribute("disabled");
            // button2.removeAllChildren();
            // button2.removeStyleAttribute("disabled");

            loginBtn.click();
            // 필수
            Thread.sleep(6000);

            HtmlPage page2 = wc.getPage("https://donderhiroba.jp/login_select.php");

            System.out.println(page2.asNormalizedText());
            // Thread.sleep(3500);

            // try {
            // HtmlAnchor button3 = page2.getAnchorByHref("javascript:void(0)");
            // button3.click();
            // } catch (Exception e) {
            // System.out.println("페이지 접속실패 ");
            // }

            // // 유저 정보 페이지
            // HtmlPage page3 = wc.getPage("https://donderhiroba.jp/index.php");
            // HtmlElement myDonImg =
            // page3.getFirstByXPath("//div[@id='mydon_area']/div[3]/div[2]/img"); // 마이동
            // 이미지

            // System.out.println("마이동 이미지 : " + myDonImg);
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

}
