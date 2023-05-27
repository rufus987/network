package error;

import java.io.*;

// собственный класс исключения
class ConvertException extends Exception{
    ConvertException(String message){
        super(message);
    }
}

public class Transcoding {
    public static void main(String[] args)  {

        try{
            copyFileUsingStream("src/win1251.txt",
                    "windows-1251",
                    "src/utf.txt",
                    "utf-8");
            System.out.println("Перекодировка прошла успешно");
        } catch(ConvertException ex){
            //перехватываем, и, если не получилось,
            // Сообщаем, что произошло
            System.out.println(ex.getMessage());
        }
    }

    private static void copyFileUsingStream(String sourceFilename, String sourceEnc,
                                            String destFilename, String descEnc) throws ConvertException{
        try (Reader fis = new InputStreamReader(new FileInputStream(new File(sourceFilename)), sourceEnc);
             Writer fos = new OutputStreamWriter(new FileOutputStream(new File(sourceFilename)), sourceEnc)) {


            char[] buffer = new char[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
        catch (FileNotFoundException ex){
            // возбуждаем собственное исключение
            throw new ConvertException("Не удалось открыть файл " + ex.getMessage());
        }
        catch (UnsupportedEncodingException ex) {
            // возбуждаем собственное исключение
            throw new ConvertException("Указана неизвестная кодировка " + ex.getMessage());
        }
        catch (IOException ex){
            // возбуждаем собственное исключение
            throw new ConvertException("Возникла ошибка при копировании");
        }
    }
}
