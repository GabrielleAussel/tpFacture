package facture;

import java.util.HashMap;

public class Catalogue {
    private HashMap<String,Article> catalogue;

    public Catalogue(){
        catalogue = new HashMap<>();
    }
    
    public void addArticle(Article article) {
         catalogue.put(article.getCode(), article);
    }
    
    public Article findByCode(String code) {
       return catalogue.get(code);
    }
    
}