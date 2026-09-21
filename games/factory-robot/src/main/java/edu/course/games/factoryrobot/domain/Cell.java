package edu.course.games.factoryrobot.domain;

/** Immutable position: row first, column second. Bounds belong to the particular map. */
public record Cell(int row, int col) {}
