# language: pt

@unitários
Funcionalidade: Alugar Filme
	Como um usuário
	Eu quero cadastrar alugueis de filmes
	Para controlar preços e datas de entrega
	
Cenario: Deve alugar um filme com sucesso
	Dado um filme 
		| estoque |   2   |
		|  preco  |   3   |
		|  tipo   | comum |
	Quando alugar
	Então o preço do aluguel será R$ 3
	E a data de entrega será em 1 dia
	E o estoque do filme será 1 unidade
	
Cenario: Não deve alugar filme sem estoque
	Dado um filme com estoque de 0 unidades
	Quando alugar
	Então não será possível por falta de estoque
	E o estoque do filme será 0 unidade
	
	
#Scenario Outline
Esquema do Cenário: Deve dar condições conforme tipo de aluguel
	Dado um filme com estoque de 2 unidades
	E que o preço de aluguel seja R$ <preco>
	E que o tipo do aluguel seja <tipo>
	Quando alugar
	Então o preço do aluguel será R$ <valor>
	E a data de entrega será em <qtdDias> dias
	E a pontuação recebida será de <pontuacao> pontos
	
#Examples
Exemplos:
	| preco |   tipo    | valor | qtdDias | pontuacao |
	|   4   | extendido |   8   |    3    |     2     |
	|   4   |   comum   |   4   |    1    |     1     |
	|   10  | extendido |   20  |    3    |     2     |
	|   5   |  semanal  |   15  |    7    |     3     |
	
	

	
	
	
	