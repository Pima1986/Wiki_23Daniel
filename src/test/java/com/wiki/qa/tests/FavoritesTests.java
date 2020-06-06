package com.wiki.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesTests extends TestBase{

    @Test
    public void testAddToFavorites(){
        app.findArticle("Henry Ford");
        app.addToFavorites();
        app.closeArticle();
        app.goToFavorites();
        app.openMyList();
        app.checkArticlePresent();
        Assert.assertTrue(app.checkArticlePresent());
        Assert.assertEquals(app.getArticleName(), "Henry Ford");
    }


    @Test
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
