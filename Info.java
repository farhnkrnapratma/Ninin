import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Info here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Info extends Actor
{
    public Info()
    {   GreenfootImage img = getImage(); // Ambil gambar karakter
        img.scale(150, 70); // Ubah ukurannya jadi 50x50 piksel
        setImage(img);
    }
}
