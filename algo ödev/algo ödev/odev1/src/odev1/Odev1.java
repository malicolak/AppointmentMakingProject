
package odev1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;



class kisi{
  String ad;
  String soyad;
  String eposta;
  String telefon;
  public kisi(){
      
  }
   public kisi(String ad,String soyad,String eposta,String telefon){
       this.ad = ad;
       this.soyad = soyad;
       this.eposta = eposta;
       this.telefon = telefon;
   }
}
class ogrenci extends kisi {
    String bolum;
    int kayityili;
    int numara;
    public ogrenci(){
        
    }
    public ogrenci(int numara,int kayityili,String bolum,String ad,String soyad,String eposta,String telefon){
       super(ad,soyad,eposta,telefon);
        this.bolum = bolum;
        this.kayityili = kayityili;
        this.numara = numara;
       
        
        
        
    }
    public void randevual(int no,int sicilnumara,String tarih,String bassaat,String bitissaat){
     try(BufferedWriter yaz = new BufferedWriter(new FileWriter("randevular.txt",true))){
         yaz.write(no+" ");
         yaz.write(sicilnumara+" ");
         yaz.write(tarih+" ");
         yaz.write(bassaat+" ");
         yaz.write(bitissaat+" ");
         yaz.newLine();
     }catch(Exception e){
         System.out.println("Dosya hatası oluştu. Lütfen programı tekrar çalıştırıp deneyiniz.");
     }   
    }
    public void randevulistele(){
      try(BufferedReader listeci = new BufferedReader(new FileReader("randevular.txt"))){
          String suankisatir = listeci.readLine();
          while(suankisatir != null){
              System.out.println(suankisatir);
              suankisatir = listeci.readLine();
          }
      }catch(Exception e){
          System.out.println("Dosya boş.\n"
                  + "Lütfen programı çalıştırıp randevu alma işlemi yaptıktan sonra tekrar deneyiniz."); 
          System.exit(0);
      }  
    }
    @Override
    public String toString(){
       return "Öğrenci no:"+numara+" kayıt yılı:"+kayityili+" bölümü:"+bolum+" adı:"+ad+" soyadı:"+soyad+" eposta:"+eposta+" telefon:"+telefon; 
    }
}
class akademisyen extends kisi{
   int sicilno;
   String anabilim;
   String unvan;
   public akademisyen(){
       
   }
   public akademisyen(int sicilno,String anabilim,String unvan,String ad,String soyad,String eposta,String telefon){
      super(ad,soyad,eposta,telefon);
       this.sicilno = sicilno;
      this.anabilim = anabilim;
      this.unvan = unvan;
      
   }
   public void randevularim(int no){
     try(BufferedReader okuma = new BufferedReader(new FileReader("randevular.txt"))){
      String kontrol = okuma.readLine();
      boolean kontrolcu = false;
      while(kontrol != null){
          String dizi[] = kontrol.split(" ");
          if(no == Integer.parseInt(dizi[1])){
              System.out.println(kontrol);
              kontrolcu = true;
          }
          kontrol = okuma.readLine();
      }
      if(kontrolcu ==false){
          System.out.println("Bu sicilno ile oluşturulmuş bir randevu yok.\n"
                  + "Bu sicilno ile bir randevu oluşturup tekrar deneyiniz.");
      }
     }
     catch(Exception e){
         System.out.println("Dosya boş.\n"
                 + "Lütfen randevu kaydettikten sonra tekrar deneyiniz.");
         System.exit(0);
     }
   }
   @Override
   public String toString(){
      return "Akademisyenin sicil nosu:"+sicilno+" anabilimi:"+anabilim+" ünvanı:"+unvan+" adı:"+ad+" soyadı:"+soyad+" epostası:"+eposta+" telefon numarası:"+telefon; 
   }
}
public class Odev1 {


public static void listele(int a){
    if(a == 1){
    try(BufferedReader listeleyici = new BufferedReader(new FileReader("ogrenci.txt"))){
        String oankisatirdaki = listeleyici.readLine();
        while(oankisatirdaki != null){
            System.out.println(oankisatirdaki);
            oankisatirdaki = listeleyici.readLine();
        }
    }
    catch(Exception e){
        System.out.println("Dosya boş.\n"
                + "Lütfen programı çalıştırıp kayıt yaptıktan sonra tekrar deneyiniz.");
        System.exit(0);
    }
    }
    else if(a == 2){
        try(BufferedReader listeleyici = new BufferedReader(new FileReader("akademisyen.txt"))){
            String oankisatirdaki = listeleyici.readLine();
            while(oankisatirdaki != null){
                System.out.println(oankisatirdaki);
                oankisatirdaki = listeleyici.readLine();
            }
        }catch(Exception e){
            System.out.println("Dosya boş.\n"
                    + "Lütfen programı çalıştırıp kayıt yaptıktan sonra tekrar deneyiniz.");
        }
    }
    else{
        System.out.println("Lütfen sadece 1 veya 2 giriniz.");
        System.exit(0);
    }
}
public static String[] ogroku(){
    String kelimedizi[] = new String[1000];
   try(BufferedReader alici = new BufferedReader(new FileReader("ogrenci.txt"))){
       String satirci = alici.readLine();
       
       while(satirci != null){
            
            int i;
            for (i = 0; i <satirci.split(" ").length; i++) {
               kelimedizi[i]=satirci.split(" ")[i];
                System.out.print(kelimedizi[i]);
                System.out.print(" ");
           }
            System.out.println(" ");
           satirci = alici.readLine();
       }
       
   }
   catch(Exception e){
       System.out.println("Dosya boş.\n"
               + "Lütfen kayıt yaptıktan sonra programı tekrar çalıştırıp deneyiniz.");
       System.exit(0);
   }
 return kelimedizi;  
}
    public static void main(String[] args) {
        System.out.println("Bu bir randevu alma programıdır.\n Öğrenci eklemek istiyorsanız (1) e,\n"
                + "akademisyen eklemek istiyorsanız (2) ye,\n"
                + "randevu almak istiyorsanız (3) e,\n"
                + "randevuları listelemek istiyorsanız (4) e,\n"
                + "öğrenci veya akademisyenleri listelemek istiyorsanız(5) e,\n"
                + "öğrenci bilgilerini bir dizi olarak geri döndürmek istiyorsanız (6) ya,\n"
                + "sicilnosu girilen akademisyenin randevularını listelemek içim (7) ye,\n"
                + "basınız."
                );
        Scanner s = new Scanner(System.in);
        try{
        int istekno = s.nextInt();
        if(istekno == 1){
            try(BufferedWriter yazici = new BufferedWriter(new FileWriter("ogrenci.txt",true))){
                System.out.println("Öğrencinin numarasını giriniz.");
                int numara =s.nextInt();
               try(BufferedReader okuyucu = new BufferedReader(new FileReader("ogrenci.txt"))){
                   String oankisatir = okuyucu.readLine();
                   
                   
                   while(oankisatir != null)
                   {
                       String[]kelimedizisi = oankisatir.split(" ");
                       if(numara == Integer.parseInt(kelimedizisi[0])){
                           System.out.println("Bu öğrenci numarasıyla kayıtlı bir öğrenci zaten var.\n"
                                   + "Lütfen başka bir numara ile kayıt oluşturunuz.");
                           System.exit(0);
                           
                       }
                       oankisatir = okuyucu.readLine();
                   }
               }catch(Exception e){
                   
               }
                
                System.out.println("Öğrencinin kayıt yılını giriniz. ");
                int kayityili = s.nextInt();
                System.out.println("Öğrencinin bölümünü birleşik bir şekilde giriniz.");
                String bolum = s.next();
                System.out.println("Öğrencinin adını birleşik bir şekilde giriniz.");
                String ad = s.next();
                System.out.println("Öğrencinin soyadını giriniz.");
                String soyad = s.next();
                System.out.println("Öğrencinin e-postasını giriniz.");
                String eposta = s.next();
                System.out.println("Öğrencinin telefon numarasını giriniz.");
                String telno = s.next();
                System.out.println("Öğrenci Başarıyla Kaydedildi!!");
                System.out.println(" ");
                
                ogrenci o1 = new ogrenci(numara,kayityili,bolum ,ad,soyad,eposta,telno);
                System.out.println("Öğrenci bilgilerini string olarak görüntülemek için (1) e basınız.");
                System.out.println("İşlemi bitirmek için herhangi bir tuşa basınız.");
                Scanner istek = new Scanner(System.in);
                String isteknumarasi = istek.next();
                if(isteknumarasi.equalsIgnoreCase("1")){
                    System.out.println(o1.toString());
                }
                yazici.write(o1.numara+" ");
                yazici.write(o1.kayityili+" ");
                yazici.write(o1.bolum+" ");
                yazici.write(o1.ad+" ");
                yazici.write(o1.soyad+" ");
                yazici.write(o1.eposta+" ");
                yazici.write(o1.telefon);
                yazici.newLine();
                System.out.println("Programı tekrar başlatarak yeni işlemler yapabilirsiniz.");
            }catch(Exception e){
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar kayıt yapınız.");
            }
        }
        else if(istekno == 2){
            try(BufferedWriter yazici = new BufferedWriter(new FileWriter("akademisyen.txt",true))){
                System.out.println("Akademisyenin sicil nosunu giriniz.");
                int sicilno = s.nextInt();
                try(BufferedReader okuyucu1 = new BufferedReader(new FileReader("akademisyen.txt"))){
                    String oankisatir1 = okuyucu1.readLine();
                    while(oankisatir1 != null){
                        String kelimedizisi1[] = oankisatir1.split(" ");
                        if(sicilno == Integer.parseInt(kelimedizisi1[0])){
                            System.out.println("Bu sicil no ile kayıtlı bir akademisyen zaten var.\n"
                                    + "Lütfen programı tekrar başlatarak farklı bir sicil no ile\n"
                                    + "kayıt oluşturunuz.");
                            System.exit(0);
                        }
                        oankisatir1 = okuyucu1.readLine();
                    }
                }catch(Exception e){
                      System.out.println("Hatalı giriş yaptınız. Lütfen rakam kullanınız.");  
                      System.exit(0);
                        }
                System.out.println("Akademisyenin anabilimini birleşik bir şekilde giriniz. ");
                String anabilim = s.next();
                System.out.println("Akademisyenin unvanını birleşik bir şekilde giriniz.");
                String unvan = s.next();
                System.out.println("Akademisyenin adını birleşik bir şekilde giriniz.");
                String ad = s.next();
                System.out.println("Akademisyenin soyadını giriniz.");
                String soyad = s.next();
                System.out.println("Akademisyenin e-postasını giriniz.");
                String eposta = s.next();
                System.out.println("Akademisyenin telefon numarasını giriniz.");
                String telno = s.next();
                System.out.println("Akademisyen Başarıyla Kaydedildi!!");
                System.out.println(" ");
                akademisyen a1 = new akademisyen(sicilno,anabilim,unvan,ad,soyad,eposta,telno);
                System.out.println("Akademisyen bilgilerini string olarak görüntülemek için (1) e basınız.");
                System.out.println("İşlemi bitirmek için herhangi bir tuşa basınız.");
                Scanner istek = new Scanner(System.in);
                String isteknumarasi = istek.next();
                if(isteknumarasi.equalsIgnoreCase("1")){
                    System.out.println(a1.toString());
                }
                yazici.write(a1.sicilno+" ");
                yazici.write(a1.anabilim+" ");
                yazici.write(a1.unvan+" ");
                yazici.write(a1.ad+" ");
                yazici.write(a1.soyad+" ");
                yazici.write(a1.eposta+" ");
                yazici.write(a1.telefon);
                yazici.newLine();
                System.out.println("Programı tekrar başlatarak yeni işlemler yapabilirsiniz.");
        }catch(IOException e){
                System.out.println("Dosya hatası var. Lütfen tekrar deneyiniz.");
                System.exit(0);
        }
            catch(Exception e){
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar kayıt yapınız.");
            }
        
    }
        else if(istekno == 3){
            try(BufferedWriter yazici = new BufferedWriter(new FileWriter("randevular.txt",true))){
                ogrenci o1 = new ogrenci();
                System.out.println("Randevu alacak öğrencinin numarasını giriniz. ");
                int numara = s.nextInt();
                try(BufferedReader randevucu = new BufferedReader(new FileReader("ogrenci.txt"))){
                String oankisatiri = randevucu.readLine();
                boolean kontrol = false;
                while(oankisatiri != null){
                    String kelimedizi[] = oankisatiri.split(" ");
                    if(numara == Integer.parseInt(kelimedizi[0])){
                        kontrol = true;
                        break;
                    }
                     oankisatiri = randevucu.readLine();
                }
                if(kontrol == false){
                    System.out.println("Bu numarayla kayıtlı bir öğrenci yok\n"
                            + "Bu numarayla kayıt oluşturduktan sonra randevu alabilirsiniz.");
                    System.exit(0);
                }
                }
                System.out.println("Randevu alınacak akademisyenin sicil nosunu giriniz.");
                int sicilno = s.nextInt();
                try(BufferedReader randevucu = new BufferedReader(new FileReader("akademisyen.txt"))){
                String oankisatiri = randevucu.readLine();
                boolean kontrol = false;
                while(oankisatiri != null){
                    String kelimedizi[] = oankisatiri.split(" ");
                    if(sicilno == Integer.parseInt(kelimedizi[0])){
                        kontrol = true;
                        break;
                    }
                     oankisatiri = randevucu.readLine();
                }
                if(kontrol == false){
                    System.out.println("Bu numarayla kayıtlı bir akademisyen yok\n"
                            + "Bu numarayla kayıt oluşturduktan sonra randevu alabilirsiniz.");
                    System.exit(0);
                }
                }
                System.out.println("Randevu tarihinin yılını giriniz.");
                String randevutarihininyılı = s.next();
                if(Integer.parseInt(randevutarihininyılı)>=2020){
                    
                }
                else{
                    System.out.println("Programı tekrar başlatıp yılı 2020 ve üstü seçiniz.");
                    System.exit(0);
                }
                System.out.println("Randevu tarihinin ayını tek basamaklıların önüne sıfır koymadan giriniz.");
                String randevutarihininayi = s.next();
                if(Integer.parseInt(randevutarihininayi)<=12&&Integer.parseInt(randevutarihininayi)>=1){
                    
                }
                else{
                    System.out.println("Programı tekrar başlatıp ayı 1 ila 12 arasında seçin");
                    System.exit(0);
                }
                System.out.println("Randevu tarihinin gününü tek basamaklıların önüne sıfır koymadan giriniz.");
                String randevutarihiningunu = s.next();
                if(Integer.parseInt(randevutarihiningunu)<=31&&Integer.parseInt(randevutarihiningunu)>=1){
                    
                }else{
                    System.out.println("Programı tekrar başlatıp günü 1 ila 31 arasında seçin");
                    System.exit(0);
                }
                System.out.println("Randevu tarihinin başlangıç saatini saat ile dakika arasında\n"
                        + "iki nokta olacak şekilde giriniz.");
                String randevutarihininbassaati = s.next();
                System.out.println("Randevu tarihinin bitiş saatini saat ile dakika arasında\n"
                        + "iki nokta olacak şekilde giriniz.");
                String randevutarihininbitsaati = s.next();
                
                String tumtarih = randevutarihininyılı+"/"+randevutarihininayi+"/"+randevutarihiningunu;
                try(BufferedReader oku = new BufferedReader(new FileReader("randevular.txt"))){
                    String oanki = oku.readLine();
                    while(oanki != null){
                        String dizikontrol[] = oanki.split(" ");
                        if(sicilno==Integer.parseInt(dizikontrol[1])&&tumtarih.equalsIgnoreCase(dizikontrol[2])){
                            System.out.println("Bu tarihte akademisyenin randevusu vardır.\n"
                                    + "Lütfen yeni bir tarih seçiniz.");
                            System.exit(0);
                        }
                        oanki = oku.readLine();
                    }
                }catch(Exception e){
                    System.out.println("Dosya hatası çıktı.\n"
                            + "Lütfen tekrar deneyiniz.");   
                }
                o1.randevual(numara,sicilno,tumtarih,randevutarihininbassaati,randevutarihininbitsaati);
                System.out.println("Randevu işlemi başarıyla gerçekleştirildi.");
            }
            catch(Exception e){
                System.out.println("Bir hata oluştu.\n"
                        + "Verileri doğru girdiğinizden emin olun.");
                System.exit(0);
            }
        }
        else if(istekno == 4){
            ogrenci o1 = new ogrenci();
            System.out.println("Randevular başarıyla aşağıya listelendi.");
            o1.randevulistele();
        }
        else if(istekno == 5){
            System.out.println("Öğrencileri listelemek istiyorsanız (1) e,\n"
                    + "Akademisyenleri listelemek istiyorsanız (2) ye basınız.");
            int karar = s.nextInt();
            if(karar == 1){
                System.out.println("Öğrenciler başarıyla aşağıya listelendi.");
            }
            else if(karar == 2){
                System.out.println("Akademisyenler başarıyla aşağıya listelendi.");
            }
            listele(karar);
        }
        else if(istekno == 6){
            
            System.out.println("Öğrenci bilgileri başarıyla dizi olarak geri döndürülüp görüntülendi.");
            String ogrdizi[] = ogroku();
            
        }
        else if(istekno == 7){
            System.out.println("Randevularını sıralayacağınız akademisyenin sicilnosunu yazınız.");
            int no = s.nextInt();
            akademisyen a = new akademisyen();
            System.out.println("Akademisyenin randevuları başarılı bir şekilde listelendi.");
            a.randevularim(no);
        }
        else{
            System.out.println("Lütfen belirtilen rakamlardan başka bir şey girmeyiniz.");
            System.exit(0);
        }
        }
        catch(InputMismatchException e){
            System.out.println("Lütfen sadece rakam giriniz.");
        }
}
}
