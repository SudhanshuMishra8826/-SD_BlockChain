
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sudhanshu Mishra
 */
public class SD_chain {
    public static ArrayList<Block> BlockChain=new ArrayList<Block>(); 
    public static int difficulty=5;
    public static void main(String[] args) {
        BlockChain.add(new Block("0001","0"));
        System.out.println("Minning Block 1....\n");
        BlockChain.get(0).minefunc(difficulty);
        BlockChain.add(new Block("0010",BlockChain.get(BlockChain.size()-1).hash));
        System.out.println("Minning Block 2....\n");
        BlockChain.get(1).minefunc(difficulty);
        BlockChain.add(new Block("0011",BlockChain.get(BlockChain.size()-1).hash));
        System.out.println("Minning Block 3....\n");
        BlockChain.get(2).minefunc(difficulty);
        System.out.println("THE CHAIN IS VALID = "+checkChainValidity());
        String BlockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(BlockChain);		
        System.out.println(BlockChainJson);
        
        
    }
    public static String checkChainValidity(){
        Block currBlock;
        Block prevBlock;
        
        for(int i=1;i<BlockChain.size();i++){
        currBlock=BlockChain.get(i);
        prevBlock=BlockChain.get(i-1);
        if(!currBlock.hash.equals(currBlock.calchash())){
        return "false";}
        else if(!currBlock.previoushash.equals(prevBlock.hash)){
        return "false";}
       }
        return "true";
    }
}
