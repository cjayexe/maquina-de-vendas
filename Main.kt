
fun main() {
    val produtos = arrayOf("Agua", "Refrigerante", "Salgadinho", "Chocolate")
    val precos = doubleArrayOf(2.0, 5.0, 4.0, 3.0)
    val estoque = intArrayOf(10, 10, 0, 10)

    var continuar = true

    while (continuar) {
        exibirTitulo()
        exibirMenu(produtos, precos)

        print("Escolha um produto: ")
        val escolha = readlnOrNull()?.toIntOrNull() ?: -1

        if (escolha == 0) {
            println("Programa encerrado.")
            continuar = false
        } else if (escolha < 1 || escolha > produtos.size) {
            println("Opcao invalida!")
        } else {
            val indice = escolha - 1

            println("Categoria: ${obterCategoria(escolha)}")

            if (estoque[indice] <= 0) {
                println("Desculpe, ${produtos[indice]} esta sem estoque!")
            } else {
                println("Produto: ${produtos[indice]}")
                println("Preco: R$ %.2f".format(precos[indice]))
                print("Insira o valor em reais: ")

                val valorInserido = readlnOrNull()?.toDoubleOrNull() ?: 0.0

                if (valorInserido < precos[indice] || valorInserido <= 0.0) {
                    println("Dinheiro insuficiente!")
                } else if (valorInserido >= precos[indice] && estoque[indice] > 0) {
                    val troco = valorInserido - precos[indice]
                    estoque[indice]--

                    println("Compra realizada com sucesso!")
                    println("Produto liberado: ${produtos[indice]}")
                    println("Troco: R$ %.2f".format(troco))
                    println("Estoque restante: ${estoque[indice]}")

                }
            }
        }

        if (continuar) {
            println()
            print("Deseja realizar outra compra? (s/n): ")
            val resposta = readlnOrNull() ?: "n"

            if (!resposta.equals("s", ignoreCase = true)) {
                continuar = false
                println("Obrigado por utilizar a maquina de vendas!")
            }
        }
    }
}

fun exibirTitulo() {
    println("================================")
    println("       MAQUINA DE VENDAS")
    println("================================")
}

fun exibirMenu(produtos: Array<String>, precos: DoubleArray) {
    for (i in produtos.indices) {
        println("${i + 1} - ${produtos[i]} - R$ %.2f".format(precos[i]))
    }

    println("0 - Sair")
    println("================================")
}

fun obterCategoria(escolha: Int): String {
    return when (escolha) {
        1 -> "Bebida"
        2 -> "Bebida"
        3 -> "Salgadinho"
        4 -> "Doce"
        else -> "Opcao invalida"
    }
}