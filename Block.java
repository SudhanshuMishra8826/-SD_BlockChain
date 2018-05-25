
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sudhanshu Mishra
 */
public class Block {
    public String hash;
    public String previoushash;
    private String data;
    private long timestamp;
    private int cnt;
    
    Block( String data,String phash){
        this.data=data;
        this.previoushash=phash;
        this.timestamp=new Date().getTime();
        this.hash=calchash();
    }
    public String calchash(){
    String hashR=Hashgenerrator.generateHash(previoushash+data+Long.toString(timestamp)+Integer.toString(cnt));
    return hashR;
    }
    public void minefunc(int diff){
    String target=new String(new char[diff]).replace("\0","0");
    while(!target.equals(hash.substring(0,diff))){
        cnt++;
        hash=calchash();
    }
        System.out.println("Minning completed : "+hash);
    
    }
}
