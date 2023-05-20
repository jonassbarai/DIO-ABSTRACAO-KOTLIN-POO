enum class NivelFormacao{
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

class Aluno(val nome:String){
    override fun toString(): String {
        return nome
    }
}

data class ConteudoEducacional(var descricao: String, val duracao: Int = 60){

}

data class Formacao(val nome:String,val nivel:NivelFormacao, var conteudos: List<ConteudoEducacional>){

    val inscritos = mutableListOf<Aluno>()

    fun matricular(aluno:Aluno){
        inscritos.add(aluno)
    }
}

fun main(){
    // alunos
    val aluno1 = Aluno("Jonas")
    val aluno2 = Aluno("Sarah")
    val aluno3 = Aluno("Pedro")

    //conteudos educacionas
    val conteudo1 = ConteudoEducacional("Lógica de programação",20)
    val conteudo2 = ConteudoEducacional("Java")
    val conteudo3 = ConteudoEducacional("Kotlin",50)
    val conteudo4 = ConteudoEducacional("Banco de dados",20);

    //formação
    val formacao1 = Formacao("programação em kotlin e java", NivelFormacao.BASICO,listOf<ConteudoEducacional>(conteudo1,conteudo2,conteudo3,conteudo4))

    formacao1.matricular(aluno1);
    formacao1.matricular(aluno2);

    println(formacao1.nome)
    println(formacao1.nivel)

    println("Conteúdos")
    for(conteudo in formacao1.conteudos){
        println(" ${conteudo.descricao}")
    }

    println("Alunos matriculados:") ;

    for(aluno in formacao1.inscritos){
        println(" $aluno")
    }

}