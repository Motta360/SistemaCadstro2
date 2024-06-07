/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadstro2.entities;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lucas
 */
public class Aluno implements Serializable, Comparable<Aluno> {

    private String name;
    private Integer id;
    private String num_contato;
    private Double peso;
    private Integer faltas = 0;
    private LocalDate aniversario;
    private List<LocalDate> presencas = new ArrayList<>();
    private String nome_responsavel;
    private String email;
    private String endereco;
    private String bairro;
    private String cep;
    private String escola;
    private String tamanho_roupa;
    private String tamanho_calcado;
    private String categoria;
    private String faixa;
    private Integer grau;
    private String medicamento_cotinuo;
    private String observacao;
    private Boolean autorizacao_treino;
    private Boolean autorizacao_competicao;
    private Boolean autorizacao_imagem;
    private Boolean ativo = true;
    private ArrayList<DayOfWeek> diasSemana;
    public Aluno() {
    }

    public Aluno(String name, Integer id, String num_contato, Double peso, LocalDate aniversario, String nome_responsavel, String email, String endereco, String bairro, String cep, String escola, String tamanho_roupa, String tamanho_calcado, String categoria, String faixa, Integer grau, String medicamento_cotinuo, String observacao, Boolean autorizacao_treino, Boolean autorizacao_competicao, Boolean autorizacao_imagem,ArrayList<DayOfWeek> diaSemana) {
        this.name = name;
        this.id = id;
        this.num_contato = num_contato;
        this.peso = peso;
        this.aniversario = aniversario;
        this.nome_responsavel = nome_responsavel;
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.escola = escola;
        this.tamanho_roupa = tamanho_roupa;
        this.tamanho_calcado = tamanho_calcado;
        this.categoria = categoria;
        this.faixa = faixa;
        this.grau = grau;
        this.medicamento_cotinuo = medicamento_cotinuo;
        this.observacao = observacao;
        this.autorizacao_treino = autorizacao_treino;
        this.autorizacao_competicao = autorizacao_competicao;
        this.autorizacao_imagem = autorizacao_imagem;
        this.diasSemana = diaSemana;
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
        return presencas;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public ArrayList<DayOfWeek> getDiasSemana() {
        return diasSemana;
    }
    
    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getTamanho_roupa() {
        return tamanho_roupa;
    }

    public void setTamanho_roupa(String tamanho_roupa) {
        this.tamanho_roupa = tamanho_roupa;
    }

    public String getTamanho_calcado() {
        return tamanho_calcado;
    }

    public void setDiasSemana(ArrayList<DayOfWeek> diasSemana) {
        this.diasSemana = diasSemana;
    }
    
    public void setTamanho_calcado(String tamanho_calcado) {
        this.tamanho_calcado = tamanho_calcado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public Integer getGrau() {
        return grau;
    }

    public void setGrau(Integer grau) {
        this.grau = grau;
    }

    public String getMedicamento_cotinuo() {
        return medicamento_cotinuo;
    }

    public void setMedicamento_cotinuo(String medicamento_cotinuo) {
        this.medicamento_cotinuo = medicamento_cotinuo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getAutorizacao_treino() {
        return autorizacao_treino;
    }

    public void setAutorizacao_treino(Boolean autorizacao_treino) {
        this.autorizacao_treino = autorizacao_treino;
    }

    public Boolean getAutorizacao_competicao() {
        return autorizacao_competicao;
    }

    public void setAutorizacao_competicao(Boolean autorizacao_competicao) {
        this.autorizacao_competicao = autorizacao_competicao;
    }

    public Boolean getAutorizacao_imagem() {
        return autorizacao_imagem;
    }

    public void setAutorizacao_imagem(Boolean autorizacao_imagem) {
        this.autorizacao_imagem = autorizacao_imagem;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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
        return "" + id + " - " + name;
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
        return this.getName().compareToIgnoreCase(o.getName());
    }

}
