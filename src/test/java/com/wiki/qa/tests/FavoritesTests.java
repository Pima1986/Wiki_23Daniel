package com.wiki.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesTests extends TestBase{

    @Test(priority =  1)
    public void testAddToFavorites(){
        app.findArticle("Formula 1");
        app.addToFavorites();
        app.closeArticle();
        app.goToFavorites();
        app.openMyList();
        app.checkArticlePresent();
        Assert.assertTrue(app.checkArticlePresent());
        //Assert.assertEquals(app.getArticleName(), "Henry Ford");
    }


    @Test (priority = 2)
    public void testRemoveFromFavorites(){
        app.openMyList();
        app.checkArticlePresent();
        //goToFavorites
        //openMyList
        //checkArticlePresent
        //deleteArticle (swipeToLeft)
        //checkListIsEmpty

    }
}
