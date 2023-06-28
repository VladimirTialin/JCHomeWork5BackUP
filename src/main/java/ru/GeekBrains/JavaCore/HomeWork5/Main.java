package ru.GeekBrains.JavaCore.HomeWork5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Чтобы создать резервное копирование файлов, укажите путь:");
        String path = scanner.next();
        Backup backup = new Backup();
        String target = "./backup";
        File locFile = new File(path);
        File tarFile = new File(target);
        backup.copying(locFile,tarFile);
    }

}

