package com.ScienceFair;

import java.io.*;
import java.util.StringTokenizer;

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer = new StringTokenizer("");

    public InputReader(FileInputStream inputStream) {
        this.reader = new BufferedReader(
                new InputStreamReader(inputStream));
    }
    public String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }
}