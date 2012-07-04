/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.advandb.bce.articleclassifier.reader;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author lugkhast
 */
public class ArticleStorageReader {

    private List<Article> articles;

    private List<Article> jsonArrayToArticles(JSONArray jArray) throws JSONException {
        JSONObject jObj;
        Article article;
        ArrayList<Article> artcls = new ArrayList<Article>();
        
        for (int i = 0; i < jArray.length(); i++) {
            jObj = jArray.getJSONObject(i);
            article = new Article();
            article.setTitle(jObj.getString("title"));
            article.setCategory(jObj.getString("category"));
            article.setUrl(jObj.getString("url"));
            article.setText(jObj.getString("text"));
            
            artcls.add(article);
        }

        return artcls;
    }

    public ArticleStorageReader(File file) {
        FileReader fr;
        BufferedReader br;
        String tmp, json = "";

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            // Read the entire file
            while ((tmp = br.readLine()) != null) {
                // The \n isn't required, but it makes println()ing the entire
                // thing a bit less annoying.
                json += "\n" + tmp;
            }

            JSONArray jArray = new JSONArray(json);
            articles = jsonArrayToArticles(jArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Article> getArticles() {
        return articles;
    }
}
