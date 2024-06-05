/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadstro2.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lucas
 */
public class Aluno implements Serializable,Comparable<Aluno> {

    private String name;
    private Integer id;
    private String num_contato;
    private Double peso;
    private Integer faltas = 0;
    private LocalDate aniversario;
    private List<LocalDate> presenças = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(String name, Integer id, String num_contato, Double peso, LocalDate aniversario) {
        this.name = name;
        this.id = id;
        this.num_contato = num_contato;
        this.peso = peso;
        this.aniversario = aniversario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum_contato() {
        return num_contato;
    }

    public void setNum_contato(String num_contato) {
        this.num_contato = num_contato;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public List<LocalDate> getPresenças() {
        return presenças;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return ""+ id + " - "+ name;
    }

    public Integer getIdade() {
        Integer years = (int) aniversario.until(LocalDate.now(), ChronoUnit.YEARS);

        return years;
    }

    public boolean menorDeIdade() {
        Integer idade = getIdade();
        if (idade >= 18) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int compareTo(Aluno o) {
        return this.getName().compareTo(o.getName());
    }

}
