package ru.GeekBrains.JavaCore.HomeWork5;

import java.io.*;

public class Backup {
    /**
     * Резервное копирование файлов
     *
     * @param source путь к файлам
     * @param backUp - путь резервного копирования файлов
     * @throws IOException
     */
    public void copying(File source, File backUp) throws IOException {
        if (!backUp.exists()) backUp.mkdir();
        for (File file : source.listFiles()) {
            if (file.isFile()) {
                /* Решил пойти по простому пути:
                т.к мы копируем только файлы без поддиректорий, значит в этих дподдиректориях могут находится файлы
                с одинакомыми именами и расширениям, и в случае перекопирования, первый файл перезапишется вместе с имеющейся в нем информацией.
                Я хотел исключить этот момент и пытался написать условие использую сравнение имен имеющихся файлов, но голова совсем отказалась работать
                в этот момент, и по этому я решил, что при создании резервного копировани файлов, их имена будут состоять из имени директории и имени файла,
                в таком случае будет понятно из какой папки и какой файл был скопирован.
                Костыл, но к сожалению в связи с последнии событиями и моей работой в МВД я не смог реализовать так ак хотел.
                */
                copyFile(file, new File(  backUp + "/" + source.getName()+"_"+file.getName()));
            }
            else

                copying(file,backUp);
        }
    }
    /**
     * Копрование файлов в директории
     *
     * @param source путь к файлам
     * @param backUp - путь резервного копирования файлов
     * @throws IOException
     */
    public  void copyFile(File source, File backUp) throws IOException {
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(backUp);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count=in.read(buffer)) != -1) {

            out.write(buffer, 0, count);
        }
        in.close();
        out.close();
    }
}