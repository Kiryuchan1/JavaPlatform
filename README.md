# Repository for the Software Development on the Java Platform subject

**Group**: IA-24
**Author**: Kyrylo Humeniuk  


## Instructions for laboratory works

- [Lab 1](#lab-1)
- [Lab 2](#lab-2)
- [Lab 3](#lab-3)
- [Lab 4](#lab-4)
- [Lab 5](#lab-5)
- [Lab 6](#lab-6)

---

## Lab 1

### Source code
[Main.java](https://github.com/Kiryuchan1/JavaPlatform/blob/main/Lab1/src/Main.java)
### How to use
In method `main` set your matrices in variables `matrix1` and `matrix2`:

```java
long[][] matrix1 = {
                    {13, 0, 24},
                    {164, 122, 2},
                    {2, 1, 1}
};

long[][] matrix2 = {
                    {39, 82, 4},
                    {2, 1, 1},
                    {2, 2, 0}
};
```
and then run code

## Lab 2

### Source code
[Main.java](https://github.com/Kiryuchan1/JavaPlatform/blob/main/Lab2/src/Main.java)
### How to use
In method `main` set your text in variable `text`:

```java
StringBuilder text = new StringBuilder("Hello world. May the chaos take the world. The ring must be destroyed.");
```
and then run code

## Lab 3

### Source code
[СlothingManager.java](https://github.com/Kiryuchan1/JavaPlatform/blob/main/Lab3/src/ClothingManager.java)
### How to use
In class `ClothingManager` find method `main` and set your `clothingList` parameters:

```java
List<Clothing> clothingList = new ArrayList<>();
        clothingList.add(new Clothing("T-Shirt", "Top", "M", "Red", 200));
        clothingList.add(new Clothing("Jeans", "Bottom", "L", "Blue", 300));
        clothingList.add(new Clothing("Jacket", "Outerwear", "X", "Black", 500));
        clothingList.add(new Clothing("Sweater", "Top", "S", "Green", 400));
        clothingList.add(new Clothing("Shorts", "Bottom", "M", "Yellow", 350));
```
After that find `targetClothing` variable below and set parameters you want to find
```java
Clothing targetClothing = new Clothing("Jeans", "Bottom", "L", "Blue", 300);
```
and then run code  

## Lab 4

### Source code
[Main.java](https://github.com/Kiryuchan1/JavaPlatform/blob/main/Lab4/src/Main.java)
### How to use
In class `Main` find method `main` and set your input text in `Text` object:

```java
Text text = new Text(
    "Hello world.   May the chaos take the world. The ring must be destroyed.");

```
and then run code

## Lab 5

### Source code
[Main.java](https://github.com/Kiryuchan1/JavaPlatform/blob/main/Lab5/src/Main.java)
### How to use
In class `Main` find method `main` and set your `album` parameters:

```java
Album album = new Album();
        try {
            album.addTrack(new RockTrack("Highway to Hell", "AC/DC", 200, "Hard Rock"));
            album.addTrack(new PopTrack("Shape of You", "Ed Sheeran", 230, true));
            album.addTrack(new ClassicalTrack("Moonlight Sonata", "Beethoven", 360, "Beethoven"));
            album.addTrack(new PopTrack("Blinding Lights", "The Weeknd", 200, true));
            album.addTrack(new RockTrack("Bohemian Rhapsody", "Queen", 354, "Progressive Rock"));
            album.addTrack(new ClassicalTrack("The Four Seasons", "Vivaldi", 700, "Vivaldi"));
```
After that find `minDuration` and `maxDuration` variables below and set values you want
```java
int minDuration = 200;
int maxDuration = 300;
```
and then run code  

## Lab 6

### Source code
[Main.java](https://github.com/Kiryuchan1/JavaPlatform/blob/main/Lab6/src/Main.java)
### How to use
In class `Main` find method `main` and set your parameters of `List<MusicTrack>`:

```java
List<MusicTrack> listRetain = new ArrayList<>(Arrays.asList(
                    new ClassicalTrack("Symphony No. 5", "Beethoven", 300, "Beethoven"),
                    new RockTrack("Back In Black", "AC/DC", 210, "Hard Rock"),
                    new RockTrack("Bohemian Rhapsody", "Queen", 354, "Progressive Rock"),
                    new PopTrack("Blinding Lights", "The Weeknd", 200, true)
));
```
It`s not recomended to add new objects since output may be wrong.   
And then run code  
