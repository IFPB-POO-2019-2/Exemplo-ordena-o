package com.ifpb.exemplo.visao;

import com.ifpb.exemplo.modelo.Pessoa;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class App {

    public static void main(String[] args) {

        Pessoa[] pessoas = {
                new Pessoa("111.111.111-01", "João",
                        LocalDate.of(1990,1,2)),
                new Pessoa("222.222.222-02", "Maria",
                        LocalDate.of(1989,5,1)),
                new Pessoa("333.333.333-03", "Ana",
                        LocalDate.of(1992,5,1))
        };

//        Comparador comparador = new Comparador();
//        Arrays.sort(pessoas, comparador);
//        System.out.println(Arrays.toString(pessoas));

        //Class interna anônima
        Comparator<Pessoa> comparador = new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        };

        Arrays.sort(pessoas, comparador);
        System.out.println(Arrays.toString(pessoas));

    }

    //Classe interna
    private static class Comparador implements Comparator<Pessoa>{
        @Override
        public int compare(Pessoa o1, Pessoa o2) {
            return o1.getNome().compareTo(o2.getNome());
        }
    }


}
