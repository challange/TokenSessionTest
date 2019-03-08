package com.example.jwt.test;

import com.example.jwt.utils.JwtUtil;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019/3/8 10:47 AM
 */
public class TreadsGetTokenTest implements Runnable {
    String token = "eyJhbGciOiJSUzI1NiJ9.eyJmaXJzdE5hbWUiOiJ0ZXN0IiwibGFzdE5hbWUiOiJ0ZXN0Iiwicm9sZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiJdLCJpc0FkbWluIjp0cnVlLCJ1c2VySWQiOiI2NjYiLCJ1c2VybmFtZSI6ImhlbGxvIiwic3ViIjoiNjY2IiwiaWF0IjoxNTUyMDEyNzc5LCJleHAiOjE1NTIwMTYzNzl9.SxM2Ceee_yvprYTLFNk-egXs_PvlMKBazP1qqxV5Lbiu61hSKdVH5DwO-BeVj5-myF-YuhGrNhBDyTLEo_-8cgW3wTxXwwIaI_PFjtEE-GSEBaJfVZ2KxYiELz4-1599YZz1M3nMiLUWtsDo0GkHWVAeVzgaVaNuA235uSI_vwVVixRXFm_dAMhStlVxHh-U2swaSDhbbxJW_Bo1xY8UkTGedn5dHX53siEdjqJOpr7Kk_z-jxuL7jVAU9SuaqLuCQ7lbnOqFImTmL46OJxyLapP6Z4QJEAmq0C7XzQS3i1uiFFGwi1P99YWhbIzVYkK1hongMdMRmyDqOt4023PTg";
    JwtUtil jwt =new JwtUtil();

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            jwt.getUserIdFromRequest(token);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TreadsGetTokenTest treadsGetTokenTest = new TreadsGetTokenTest();

        for(int i = 0; i < 10; i++){
            new Thread(treadsGetTokenTest, String.valueOf(i)).start();
        }
    }
}
