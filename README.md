# Java Springboot RSA Crypt decode and encode demo

RSA加解密示例
请求方式 POST|GET  
请求类型 form-data 或者  json

## Docker 容器运行
运行Spring Rsa Crypt
~~~sh
docker run -itd --name spring-rsa-crypt -p 8080:8080 tekintian/spring-rsa-crypt:0.0.1
~~~

## RSA加密
http://localhost:8080/

参数说明:
txtStr   要加密的字符串
publicKey   RSA供匙
privateKey   RSA私匙
genKey  创建RSA密匙对


## RSA解密
http://localhost:8080/rsaDecrypt.do

参数说明:
rsaBase64Str   待解密的RSA加密字符串
privateKey   RSA加密字符串对应的私匙


## 请求示例:

请求地址: 
http://localhost:8080/?txtStr=我是要加密的内容&genKey=true

返回内容:
~~~json
{
code: 0,
msg: "OK",
data: {
txtStr: "我是要加密的内容",
RSAPublicKey: "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9v3wcQCHG2WmJOE5N2Nz1qBfQGqSzLS9YocMxrYfeTFeSjUv+M+zZddaszVW6dkFB1SaBBQnZ1K1sATdYMf+XsQ6+NwQCUaDQW0na2LkF3St/epMIB2F4Hwir1ByDg6TLSSdZkbtQRz2BKcu7++Lc0ZG4Fdsd0UM8tWEczSb8QwIDAQAB",
rsaBase64Str: "R/pUW58LL5Q71EfnaaR76yuemxlIoZqy1uog1wTndD9fRPSu2eOIwb+DK6iTCEOScdo0Ae/+91qTtiQ650XSBLjt1F1rQklOIeoZtOHiTRrDZM0aD00ZbekTSo7WkKDBjbSylwS1K+woatosom5ifHUhUilgGRgjW/NHdJp3kdM=",
RSAPrivateKey: "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL2/fBxAIcbZaYk4Tk3Y3PWoF9AapLMtL1ihwzGth95MV5KNS/4z7Nl11qzNVbp2QUHVJoEFCdnUrWwBN1gx/5exDr43BAJRoNBbSdrYuQXdK396kwgHYXgfCKvUHIODpMtJJ1mRu1BHPYEpy7v74tzRkbgV2x3RQzy1YRzNJvxDAgMBAAECgYA8abUYQYr/hsVFPTohKwTe6g/64CDEM4S5kXdWX8u8iU3wiTBC1UF50zzwc8fxwCjyzuydc385ba9xjcmTOQgJNIsZl7ho1ouJLGAXbDFJgIgjEeMCo5JGclH+/5vo2mINT4K0B+MF4SqsQKmzXDLVOrpppXTOyiVH6iV7oVUlUQJBAPos5VjykLLU8tySCK7hjFDT+7+e/WxWzblLc6SI1zqEHUXf61bwGZmqvjTnTeMPC3qdzeXcdc71zF8qtGczKo8CQQDCKm1unmFp8BxP6NMqftlYTVxldqw6KAMkcHl14+ev+lTTA3eey7tTV49DokCIM2xGZPRfReK9eU+o6VBK2n0NAkBTwHv3Tx1KAShc1za49SE4Xf9Fo0BL6LNueOf6CSWknV3/ansq2652V0beByF4Bi1dmz622RtHcdo9cdp7QhHZAkEArZ0STJ8Bq6AvMKSWbKEP5o0F2RPL3BR6+tI3SNqICCpmPmgTRcIVtefNCkTCPwb8AdWzTJ1IqPMX74jvan8C4QJBANkaQbn0ulnEoVT89QI6ishIosHcvpt5xqI+1+3iWheUyu3BNbvZfyEpF7mdeQ9h42Xy2PyV1hX7EOpQsDXr1aM="
}
}
~~~

