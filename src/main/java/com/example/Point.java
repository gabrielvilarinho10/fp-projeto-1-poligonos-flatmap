package com.example;

import java.awt.geom.Point2D;

/**
 * Representa um ponto com coordenadas x e y.
 * Um record é uma classe imutável (shallow immutability) que possui um construtor, getters e toString,
 * não possuindo setters.
 *
 * @param x        coordenada horizontal
 * @param y        coordenada vertical
 * @param distance distância de um ponto anterior.
 *                 Informe 0 se não for calcular ou não existir um ponto anterior ou use o construtor {@link #Point(double, double)}.
 * @author Manoel Campos
 */
public record Point(double x, double y, double distance) {
    /**
     * Cria um ponto com coordenadas x e y, sem definir uma distância para um ponto anterior (que será zero).
     *
     * @param x coordenada horizontal
     * @param y coordenada vertical
     */
    public Point(final double x, final double y) {
        this(x, y, 0);
    }

    /**
     * Cria um ponto com as mesmas coordenadas de um ponto p2 passado por parâmetro,
     * calculando e armazenando a soma da distância do ponto p1 para um ponto anterior,
     * com a a distância do p2 para o p1.
     * Assim, chamando este construtor consecutivamente para cada par de pontos
     * de um polígono, obtemos o último ponto contendo o perímetro do polígono no campo
     * {@link #distance}.
     *
     * @param p1 ponto anterior a p2
     * @param p2 ponto atual, cuja distância será calculada para p1
     */
    public Point(final Point p1, final Point p2) {
        this(p2.x, p2.y, p1.distance + Point2D.distance(p1.x, p1.y, p2.x, p2.y));
    }
}