package com.weidmuller.utilities;

import java.util.ArrayList;
import java.util.List;

public class StoryGenerator {

    public static List<String> storyList=new ArrayList<>();
    public static List<String> nameList=new ArrayList<>();

    public static void addStoryToList(String story){

        storyList.add(story);
    }


    public static void removeStoryFromList(String story){

        storyList.remove(story);

    }

    public static void nameList(String name){

        nameList.add(name);
    }


}
