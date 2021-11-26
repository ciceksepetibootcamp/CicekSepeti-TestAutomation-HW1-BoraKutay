# Çiçeksepeti Test Otomasyon Bootcamp ÖDEV-2 ~ Bora Kutay Keskinoğlu 

## Ödev 1 
<a href="https://docs.google.com/spreadsheets/d/1r2GweE0ZIFQu-z-Lf2DQ_g0jGBwrAzj2jN0rUiHz8h8/edit?usp=sharing" target="blank"> <img align="left" alt="borakutay | eTablo" width="22px" src="https://cdn.jsdelivr.net/npm/simple-icons@v3/icons/google.svg" />
  <br>
## UserOperationsTest Sınıfı 
### Test Senaryosu 1 - Üye Girişi

* Üye girişi butonuna tıklanır.    
* E-posta ve parola doğru bir şekilde girilir.   
* Giriş butonuna tıklanır.    
* Başarıyla giriş yapıldığı görülür.   

### Test Senaryosu 2 - Üye ol

* Üye ol butonuna tıklanır.   
* Ad soyad, e-Posta adresi parola girilir.  
* Üyelik sözleşmesi ve KVKK bilgilendirmesi onaylanır.  
* Üye ol butonuna tıklanır.  
* Teşekkürler sayfasının geldiği görülür.  

## SearchTest Sınıfı 

### Test Senaryosu 1 - Arama Yapma

* Kullanıcı arama yapmak istediği kelimeyi yazar.     
* Ara butonuna tıklar.    
* İlgili kelimeye dair ürünlerin geldiği URL üzerinden doğrulanır.    

### Test Senaryosu 2 - Favori ekleme (Giriş yapılmadan)

* Elektronik ürünlerin tümünü gör butonuna tıklanır.   
* Çok satanlar butonuna tıklanır.    
* İlk ürünün detay sayfasına girilir.      
* Favoriye eklenir.         
* Giriş yap sayfasına yönlendirildiği görülür.  

## Kendi verilerinizle çalıştırmak için app.config dosyası

![image](https://user-images.githubusercontent.com/27950192/143504778-9021a29e-c9de-48b2-afa7-13681584449b.png)

Kendi girdilerinizle çalıştırmak için app.config dosyasından ilgili yerleri doldurabilirsiniz.
- email ve password giriş yapma senaryosu için kullanılan girdilerdir. Sırasıyla e-Posta ve parola için kullanılır.   
- signUpName, signUpMail ve signUpPassword ise kayıt olma senaryosunda kullanılan girdilerdir. Sırasıyla Ad soyad, e-Posta ve parola için kullanılır.   
- searchItem ise arama yapmak istediğiniz kelimeyi yazmak için kullanabilirsiniz fakat şimdilik Türkçe karakter kullanmadan arama yapalım sonrasında düzeltmeye çalışacağım :) (Örneğin Çikolata yerine Cikolata yazabilirsiniz) 


![image](https://user-images.githubusercontent.com/27950192/143573767-de233b69-9445-4302-82a0-f0662fd2d651.png)

Aynı şekilde ChromeDriver'ın pathını config üzerinden ayarlayabilirsiniz.    

* driverPathDIR, driverin bulunduğu diskin girildiği alan.
* driverPath ise disk dışındaki adresin girildiği alan.


   
