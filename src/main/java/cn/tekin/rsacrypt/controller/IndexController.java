package cn.tekin.rsacrypt.controller;

import cn.tekin.rsacrypt.config.AppConfig;
import cn.tekin.rsacrypt.dto.ReturnMsg;
import cn.tekin.rsacrypt.utils.JsonUtil;
import cn.tekin.rsacrypt.utils.RSAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tekintian@gmail.com
 * @version v0.0.1
 * @since v0.0.1 2022-03-11 11:13
 */
@RestController
// @RequestMapping("/v1")
public class IndexController {

  @Autowired
  AppConfig config;

  @GetMapping("/")
  public String index(@RequestParam Map<String,Object> params, @RequestBody( required = false) Map<String,Object> reqBodyMap) {
    ReturnMsg retMsg=new ReturnMsg(0,"OK");
    if (reqBodyMap!=null && reqBodyMap.size()>0){
      params.putAll(reqBodyMap);
      reqBodyMap.clear();
    }
    String txtStr = params.get("txtStr")!=null?params.get("txtStr").toString():"admin";
    String publicKey= params.get("publicKey")!=null?params.get("publicKey").toString():null;
    String privateKey= params.get("privateKey")!=null?params.get("privateKey").toString():null;
    String genKey= params.get("genKey")!=null?params.get("genKey").toString():null;

    try {
      if (genKey != null) {
        Map<String, Object> keyPair = RSAUtils.genKeyPair();
        config.setRsaPrivateKey(RSAUtils.getPrivateKey(keyPair));
        config.setRsaPublicKey(RSAUtils.getPublicKey(keyPair));
      }
      if (privateKey != null) {
        config.setRsaPrivateKey(privateKey);
      }
      if (publicKey != null) {
        config.setRsaPublicKey(publicKey);
      }
      // 使用PublicKey加密数据
      byte[] enByte = RSAUtils.encryptByPublicKey(txtStr.getBytes(), config.getRsaPublicKey());
      // 封装返回数据
      HashMap<String, Object> result = new HashMap<String, Object>();
      result.put("RSAPublicKey", config.getRsaPublicKey());
      result.put("RSAPrivateKey", config.getRsaPrivateKey());
      result.put("txtStr", txtStr);
      result.put("rsaBase64Str", Base64Utils.encodeToString(enByte));
      retMsg.setData(result);

    } catch (Exception e) {
      //e.printStackTrace();
      retMsg.setCode(-1);
      retMsg.setMsg(e.getMessage());
    }
    return JsonUtil.toJson(retMsg);
  }

  @RequestMapping(path = "/rsaDecrypt.do")
  public String rsaDecrypt(@RequestParam Map<String,Object> params, @RequestBody( required = false) Map<String,Object> reqBodyMap) {
    ReturnMsg retMsg=new ReturnMsg(0,"OK");
    if (reqBodyMap!=null && reqBodyMap.size()>0){
      params.putAll(reqBodyMap);
      reqBodyMap.clear();
    }
    //接收参数
    String rsaBase64Str=params.get("rsaBase64Str")!=null ? params.get("rsaBase64Str").toString(): config.getRsaBase64StrDemo();
    Object privateKey=params.get("privateKey");
    // 获取数据

    if (privateKey != null) {
      config.setRsaPrivateKey(privateKey.toString());
    }
    HashMap<String, Object> result = new HashMap<String, Object>();
    try {
      // RSA私匙解密  因为rsaBase64Str为base64加密后的数据, 需要先解密后在进行私匙解密
      byte[] txtByte = RSAUtils.decryptByPrivateKey(Base64Utils.decode(rsaBase64Str.getBytes()), config.getRsaPrivateKey());

      //内部会自动解密rsaBase64Str后在rsa解密
//      final String str = RSAUtils.decryptDataOnJava(rsaBase64Str, config.getRsaPrivateKey());

      // 用map封装返回的数据
      result.put("rsaBase64Str", rsaBase64Str);
      result.put("txtStr", new String(txtByte));
      retMsg.setData(result);

    } catch (Exception e) {
      //e.printStackTrace();
      retMsg.setCode(-1);
      retMsg.setMsg(e.getMessage());
    }
    return JsonUtil.toJson(retMsg);
  }
}