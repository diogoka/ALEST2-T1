package ALES;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Arvore {

    private Nodo refRoot;

    private class Nodo{
        Nodo pai;
        String elemento;
        LinkedList<Nodo> subArvores;

        public Nodo(String umElemento) {
            pai = null;
            elemento = umElemento;
            subArvores = new LinkedList<>();
        }

        public String getElemento() {
            return elemento;
        }

        public void setElemento(String umElemento) {
            elemento = umElemento;
        }

        public Nodo getPai(){
            return pai;
        }

        public void setPai(Nodo umPai){
            pai = umPai;
        }

        public void addSubArvore(Nodo umNodo){
            umNodo.setPai(this);
            subArvores.add(umNodo);
        }

        public boolean removeSubArvore(Nodo umNodo){
            umNodo.setPai(null);
            return subArvores.remove(umNodo);
        }

        public Nodo getSubArvore(int i){
            if((i<0)||(i>=subArvores.size())){
                System.out.println("Erro. Posição inválida");
            }
            return subArvores.get(i);
        }

        public int contadorSubArvore(){
            return  subArvores.size();
        }
    }

    public Nodo searchNodeRef(String elemento, Nodo alvo){
        Nodo res = null;
        if(alvo != null){
            if(alvo.getElemento().equals(elemento)){
                res = alvo;
            }
            else {
                Nodo aux = null;
                int i= 0;
                while((aux == null) && (i<alvo.contadorSubArvore())){
                    aux = searchNodeRef(elemento, alvo.getSubArvore(i));
                    i++;
                }
                res = aux;
            }
        }
        return res;
    }

    public boolean add(String elemento, String pai){
        Nodo novo = new Nodo(elemento);
        Nodo nAux = null;
        boolean res = false;

        if (pai == null) {

            if (refRoot != null) {
                novo.addSubArvore(refRoot);
                refRoot.setPai(novo);
            }

            refRoot = novo;
            res = true;
        }
        else {
            nAux = searchNodeRef(pai, refRoot);
            if (nAux != null) {
                nAux.addSubArvore(novo);
                res = true;
            }
        }
        return res;
    }

    public ArrayList<String> traversalPre(){
        ArrayList<String> res = new ArrayList<>();
        traversalPre(refRoot, res);
        return res;
    }

    private void traversalPre(Nodo n, ArrayList<String> res) {
        if (n != null) {
            res.add(n.getElemento());
            for(int i=0; i<n.contadorSubArvore(); i++) {
                traversalPre(n.getSubArvore(i), res);
            }
        }
    }

    public ArrayList<String> traversalPos(){
        ArrayList<String> res = new ArrayList<>();
        traversalPos(refRoot, res);
        return res;
    }

    private void traversalPos(Nodo novo, ArrayList<String> res){
        if (novo != null) {
            for(int i=0; i < novo.contadorSubArvore(); i++) {
                traversalPos(novo.getSubArvore(i), res);
            }
            res.add(novo.getElemento());
        }
    }

    public ArrayList<String> traversalEmLargura(){
        ArrayList<String> res = new ArrayList<>();
        


        return res;
    }

}
