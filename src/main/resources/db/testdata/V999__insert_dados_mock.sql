-- Inserção de dados mock para testes (baseado em V2__create_vehicles.sql)
-- Insere marcas, modelos, versões, especificações, categorias, equipamentos, vínculos e fotos.

DECLARE
  v_ford_id NUMBER;
  v_toyota_id NUMBER;
  v_bmw_id NUMBER;

  v_ranger_model_id NUMBER;
  v_mustang_model_id NUMBER;
  v_corolla_model_id NUMBER;
  v_hilux_model_id NUMBER;
  v_x5_model_id NUMBER;

  v_versao_id NUMBER;

  v_cat_seguranca NUMBER;
  v_cat_conforto NUMBER;
  v_cat_tecnologia NUMBER;

  v_eq_airbag NUMBER;
  v_eq_abs NUMBER;
  v_eq_ar_cond NUMBER;
  v_eq_tela NUMBER;

BEGIN
  -- Marcas
  INSERT INTO bs_marca (nome, url_logo)
    VALUES ('Ford','https://example.com/logos/ford.png')
    RETURNING id INTO v_ford_id;

  INSERT INTO bs_marca (nome, url_logo)
    VALUES ('Toyota','https://example.com/logos/toyota.png')
    RETURNING id INTO v_toyota_id;

  INSERT INTO bs_marca (nome, url_logo)
    VALUES ('BMW','https://example.com/logos/bmw.png')
    RETURNING id INTO v_bmw_id;

  -- Modelos
  INSERT INTO bs_modelo (marca_id, nome)
    VALUES (v_ford_id, 'Ranger')
    RETURNING id INTO v_ranger_model_id;

  INSERT INTO bs_modelo (marca_id, nome)
    VALUES (v_ford_id, 'Mustang')
    RETURNING id INTO v_mustang_model_id;

  INSERT INTO bs_modelo (marca_id, nome)
    VALUES (v_toyota_id, 'Corolla')
    RETURNING id INTO v_corolla_model_id;

  INSERT INTO bs_modelo (marca_id, nome)
    VALUES (v_toyota_id, 'Hilux')
    RETURNING id INTO v_hilux_model_id;

  INSERT INTO bs_modelo (marca_id, nome)
    VALUES (v_bmw_id, 'X5')
    RETURNING id INTO v_x5_model_id;

  -- Versões e especificações (cada INSERT de versão captura id em v_versao_id)
  INSERT INTO bs_versao (modelo_id, nome, ano_fabricacao, ano_modelo, preco, nota_media, qtd_avaliacoes)
    VALUES (v_ranger_model_id, 'Ranger 3.2 Turbo', 2019, 2020, 199900.00, 4.45, 128)
    RETURNING id INTO v_versao_id;

  INSERT INTO bs_espec_motor (versao_id, tipo_motor, potencia_cv, torque_kgfm, combustivel, valvulas, consumo_cidade, consumo_estrada)
    VALUES (v_versao_id, 'V6 3.2L Turbo', 200.0, 470.0, 'Diesel', 24, '8 km/l', '11 km/l');

  INSERT INTO bs_espec_transmissao (versao_id, tipo_transmissao, marchas, tracao, diferencial)
    VALUES (v_versao_id, 'Automática', 6, '4x4', 'Traseiro') ;

  INSERT INTO bs_espec_desempenho (versao_id, aceleracao_0_100, velocidade_max, modos_conducao)
    VALUES (v_versao_id, 8.5, 180, 'Normal,Off-Road');

  INSERT INTO bs_espec_dimensao (versao_id, comprimento_mm, largura_mm, altura_mm, entre_eixos_mm, peso_kg, capacidade_carga)
    VALUES (v_versao_id, 5340, 1880, 1810, 3220, 2200, '1000 kg');

  -- Mustang
  INSERT INTO bs_versao (modelo_id, nome, ano_fabricacao, ano_modelo, preco, nota_media, qtd_avaliacoes)
    VALUES (v_mustang_model_id, 'Mustang GT V8', 2021, 2021, 466500.00, 4.80, 342)
    RETURNING id INTO v_versao_id;

  INSERT INTO bs_espec_motor (versao_id, tipo_motor, potencia_cv, torque_kgfm, combustivel, valvulas, consumo_cidade, consumo_estrada)
    VALUES (v_versao_id, 'V8 5.0L', 450.0, 55.0, 'Gasolina', 32, '6 km/l', '9 km/l');

  INSERT INTO bs_espec_transmissao (versao_id, tipo_transmissao, marchas, tracao, diferencial)
    VALUES (v_versao_id, 'Manual', 6, 'RWD', 'Diferencial Torsen');

  INSERT INTO bs_espec_desempenho (versao_id, aceleracao_0_100, velocidade_max, modos_conducao)
    VALUES (v_versao_id, 4.3, 250, 'Sport,Track');

  INSERT INTO bs_espec_dimensao (versao_id, comprimento_mm, largura_mm, altura_mm, entre_eixos_mm, peso_kg, capacidade_carga)
    VALUES (v_versao_id, 4784, 1916, 1381, 2720, 1730, '400 kg');

  -- Corolla
  INSERT INTO bs_versao (modelo_id, nome, ano_fabricacao, ano_modelo, preco, nota_media, qtd_avaliacoes)
    VALUES (v_corolla_model_id, 'Corolla GLi', 2020, 2020, 98000.00, 4.30, 210)
    RETURNING id INTO v_versao_id;

  INSERT INTO bs_espec_motor (versao_id, tipo_motor, potencia_cv, torque_kgfm, combustivel, valvulas, consumo_cidade, consumo_estrada)
    VALUES (v_versao_id, 'I4 2.0L', 170.0, 20.0, 'Flex', 16, '11 km/l', '14 km/l');

  INSERT INTO bs_espec_transmissao (versao_id, tipo_transmissao, marchas, tracao, diferencial)
    VALUES (v_versao_id, 'Automática CVT', 0, 'FWD', 'Diferencial aberto');

  INSERT INTO bs_espec_desempenho (versao_id, aceleracao_0_100, velocidade_max, modos_conducao)
    VALUES (v_versao_id, 10.2, 200, 'Eco,Normal');

  INSERT INTO bs_espec_dimensao (versao_id, comprimento_mm, largura_mm, altura_mm, entre_eixos_mm, peso_kg, capacidade_carga)
    VALUES (v_versao_id, 4620, 1775, 1460, 2700, 1250, '470 kg');

  -- Hilux
  INSERT INTO bs_versao (modelo_id, nome, ano_fabricacao, ano_modelo, preco, nota_media, qtd_avaliacoes)
    VALUES (v_hilux_model_id, 'Hilux SRV 2.8 Diesel', 2022, 2022, 220000.00, 4.55, 95)
    RETURNING id INTO v_versao_id;

  INSERT INTO bs_espec_motor (versao_id, tipo_motor, potencia_cv, torque_kgfm, combustivel, valvulas, consumo_cidade, consumo_estrada)
    VALUES (v_versao_id, 'I4 2.8L Turbo', 204.0, 500.0, 'Diesel', 16, '9 km/l', '11 km/l');

  INSERT INTO bs_espec_transmissao (versao_id, tipo_transmissao, marchas, tracao, diferencial)
    VALUES (v_versao_id, 'Automática', 6, '4x4', 'Diferencial bloqueável');

  INSERT INTO bs_espec_desempenho (versao_id, aceleracao_0_100, velocidade_max, modos_conducao)
    VALUES (v_versao_id, 9.8, 180, 'Normal,Off-Road');

  INSERT INTO bs_espec_dimensao (versao_id, comprimento_mm, largura_mm, altura_mm, entre_eixos_mm, peso_kg, capacidade_carga)
    VALUES (v_versao_id, 5335, 1855, 1815, 3085, 2500, '1200 kg');

  -- X5
  INSERT INTO bs_versao (modelo_id, nome, ano_fabricacao, ano_modelo, preco, nota_media, qtd_avaliacoes)
    VALUES (v_x5_model_id, 'X5 xDrive40i', 2021, 2021, 520000.00, 4.75, 61)
    RETURNING id INTO v_versao_id;

  INSERT INTO bs_espec_motor (versao_id, tipo_motor, potencia_cv, torque_kgfm, combustivel, valvulas, consumo_cidade, consumo_estrada)
    VALUES (v_versao_id, 'I6 3.0L Turbo', 340.0, 45.0, 'Gasolina', 24, '8 km/l', '11 km/l');

  INSERT INTO bs_espec_transmissao (versao_id, tipo_transmissao, marchas, tracao, diferencial)
    VALUES (v_versao_id, 'Automática', 8, 'AWD', 'Diferencial eletrônico');

  INSERT INTO bs_espec_desempenho (versao_id, aceleracao_0_100, velocidade_max, modos_conducao)
    VALUES (v_versao_id, 5.6, 240, 'Comfort,Sport');

  INSERT INTO bs_espec_dimensao (versao_id, comprimento_mm, largura_mm, altura_mm, entre_eixos_mm, peso_kg, capacidade_carga)
    VALUES (v_versao_id, 4922, 2004, 1745, 2975, 2200, '650 kg');

  -- Categorias de equipamentos
  INSERT INTO bs_categoria_equip (nome) VALUES ('Segurança') RETURNING id INTO v_cat_seguranca;
  INSERT INTO bs_categoria_equip (nome) VALUES ('Conforto') RETURNING id INTO v_cat_conforto;
  INSERT INTO bs_categoria_equip (nome) VALUES ('Tecnologia') RETURNING id INTO v_cat_tecnologia;

  -- Equipamentos
  INSERT INTO bs_equipamento (categoria_id, descricao) VALUES (v_cat_seguranca, 'Airbags frontais') RETURNING id INTO v_eq_airbag;
  INSERT INTO bs_equipamento (categoria_id, descricao) VALUES (v_cat_seguranca, 'ABS + Controle de Tração') RETURNING id INTO v_eq_abs;
  INSERT INTO bs_equipamento (categoria_id, descricao) VALUES (v_cat_conforto, 'Ar-condicionado automático') RETURNING id INTO v_eq_ar_cond;
  INSERT INTO bs_equipamento (categoria_id, descricao) VALUES (v_cat_tecnologia, 'Central multimídia 10"') RETURNING id INTO v_eq_tela;

  -- Vínculo entre versões e equipamentos (atribuir alguns equipamentos às versões inseridas anteriormente)
  -- Usar subselects para pegar algumas versões pelo nome
  INSERT INTO bs_versao_equipamento (versao_id, equipamento_id)
    SELECT id, v_eq_airbag FROM bs_versao WHERE nome = 'Ranger 3.2 Turbo' FETCH FIRST 1 ROWS ONLY;

  INSERT INTO bs_versao_equipamento (versao_id, equipamento_id)
    SELECT id, v_eq_abs FROM bs_versao WHERE nome = 'Ranger 3.2 Turbo' FETCH FIRST 1 ROWS ONLY;

  INSERT INTO bs_versao_equipamento (versao_id, equipamento_id)
    SELECT id, v_eq_ar_cond FROM bs_versao WHERE nome = 'Corolla GLi' FETCH FIRST 1 ROWS ONLY;

  INSERT INTO bs_versao_equipamento (versao_id, equipamento_id)
    SELECT id, v_eq_tela FROM bs_versao WHERE nome = 'Mustang GT V8' FETCH FIRST 1 ROWS ONLY;

  -- Fotos (uma principal por versão)
  INSERT INTO bs_foto_veiculo (versao_id, url_foto, is_principal)
    SELECT id, 'https://example.com/photos/ranger_1.jpg', 1 FROM bs_versao WHERE nome = 'Ranger 3.2 Turbo' FETCH FIRST 1 ROWS ONLY;

  INSERT INTO bs_foto_veiculo (versao_id, url_foto, is_principal)
    SELECT id, 'https://example.com/photos/mustang_1.jpg', 1 FROM bs_versao WHERE nome = 'Mustang GT V8' FETCH FIRST 1 ROWS ONLY;

  INSERT INTO bs_foto_veiculo (versao_id, url_foto, is_principal)
    SELECT id, 'https://example.com/photos/corolla_1.jpg', 1 FROM bs_versao WHERE nome = 'Corolla GLi' FETCH FIRST 1 ROWS ONLY;

  INSERT INTO bs_foto_veiculo (versao_id, url_foto, is_principal)
    SELECT id, 'https://example.com/photos/hilux_1.jpg', 1 FROM bs_versao WHERE nome = 'Hilux SRV 2.8 Diesel' FETCH FIRST 1 ROWS ONLY;

  INSERT INTO bs_foto_veiculo (versao_id, url_foto, is_principal)
    SELECT id, 'https://example.com/photos/x5_1.jpg', 1 FROM bs_versao WHERE nome = 'X5 xDrive40i' FETCH FIRST 1 ROWS ONLY;

  COMMIT;
END;
/
