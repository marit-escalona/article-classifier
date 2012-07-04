/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.advandb.bce.articleclassifier;

import edu.advandb.bce.articleclassifier.reader.Article;
import edu.advandb.bce.articleclassifier.reader.ArticleStorageReader;
import javax.swing.JFileChooser;

/**
 *
 * @author lugkhast
 */
public class ArticleClassifier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        ArticleStorageReader reader = null;
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            reader = new ArticleStorageReader(chooser.getSelectedFile());
            
            for (Article a : reader.getArticles()) {
                System.out.println(a.getTitle());
            }
        }
    }
}
