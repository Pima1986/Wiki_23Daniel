package com.wiki.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesTests extends TestBase{
    @Test(priority = 1)
    public void testAddToFavorites(){
        app.findArticle("Mustang shelby");
        app.addToFavorits();
        app.closeArticle();

        app.openMyLists();
        Assert.assertTrue(app.checkArticlePresent());
        //Assert.assertEquals(app.getArticleName(), "Appium");
    }

    @Test(priority = 2)
    public void testRemoveFromFavorites(){
        app.openMyLists();
        app.checkArticlePresent();

        //DeleteAtticle (swipeToLeft)
        //CheckListIsEmpty



    }
}