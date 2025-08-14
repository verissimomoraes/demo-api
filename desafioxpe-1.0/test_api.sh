#!/bin/bash

# -------------------------------
# Testes para entidade Cliente
# -------------------------------

echo "Criando cliente..."
curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{"nome": "Robson Silva", "email": "joao@email.com"}'
echo -e "\n"

echo "Buscando cliente por ID..."
curl http://localhost:8080/clientes/1
echo -e "\n"

echo "Atualizando cliente..."
curl -X PUT http://localhost:8080/clientes/1 \
  -H "Content-Type: application/json" \
  -d '{"nome": "Robson Verissimo Atualizado", "email": "joao@novoemail.com"}'
echo -e "\n"

echo "Contando clientes..."
curl http://localhost:8080/clientes/contar
echo -e "\n"

echo "Listando todos os clientes..."
curl http://localhost:8080/clientes
echo -e "\n"

echo "Buscando cliente por nome..."
curl http://localhost:8080/clientes/nome/Robson
echo -e "\n"

echo "Deletando cliente..."
curl -X DELETE http://localhost:8080/clientes/1
echo -e "\n"
# -------------------------------
# Testes para entidade Item
# -------------------------------

echo "Criando item..."
curl -X POST http://localhost:8080/items \
  -H "Content-Type: application/json" \
  -d '{"name": "Notebook", "description": "Notebook Dell", "preco": 3500.00}'
echo -e "\n"

echo "Listando todos os itens..."
curl http://localhost:8080/items
echo -e "\n"

echo "Buscando item por ID..."
curl http://localhost:8080/items/1
echo -e "\n"

echo "Deletando item..."
curl -X DELETE http://localhost:8080/items/1
echo -e "\n"
