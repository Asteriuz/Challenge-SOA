-- ==========================================
-- 1. NÚCLEO DO VEÍCULO
-- ==========================================

CREATE TABLE bs_marca (
   id         NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   nome       VARCHAR2(100) NOT NULL,
   url_logo   VARCHAR2(255)
);

CREATE TABLE bs_modelo (
   id       NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   marca_id NUMBER NOT NULL,
   nome     VARCHAR2(100) NOT NULL,
   CONSTRAINT fk_modelo_marca FOREIGN KEY ( marca_id )
      REFERENCES bs_marca ( id )
);

CREATE TABLE bs_versao (
   id             NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   modelo_id      NUMBER NOT NULL,
   nome           VARCHAR2(150) NOT NULL, -- Ex: "Raptor V6 3.0"
   ano_fabricacao NUMBER(4) NOT NULL,
   ano_modelo     NUMBER(4) NOT NULL,
   preco          NUMBER(12,2), -- Ex: 466500.00
   nota_media     NUMBER(3,2) DEFAULT 0, -- Ex: 4.80
   qtd_avaliacoes NUMBER DEFAULT 0,
   CONSTRAINT fk_versao_modelo FOREIGN KEY ( modelo_id )
      REFERENCES bs_modelo ( id )
);

-- ==========================================
-- 2. ESPECIFICAÇÕES (Cards Expansíveis)
-- ==========================================

CREATE TABLE bs_espec_motor (
   versao_id       NUMBER PRIMARY KEY,
   tipo_motor      VARCHAR2(100), -- Ex: V6 3.0L Bi-Turbo EcoBoost
   potencia_cv     NUMBER(5,1),
   torque_kgfm     NUMBER(5,1),
   combustivel     VARCHAR2(50),
   valvulas        NUMBER(2),
   consumo_cidade  VARCHAR2(50),
   consumo_estrada VARCHAR2(50),
   CONSTRAINT fk_motor_versao FOREIGN KEY ( versao_id )
      REFERENCES bs_versao ( id )
         ON DELETE CASCADE
);

CREATE TABLE bs_espec_transmissao (
   versao_id        NUMBER PRIMARY KEY,
   tipo_transmissao VARCHAR2(50), -- Automática, Manual
   marchas          NUMBER(2),
   tracao           VARCHAR2(50), -- 4x4, AWD, FWD
   diferencial      VARCHAR2(150),
   CONSTRAINT fk_trans_versao FOREIGN KEY ( versao_id )
      REFERENCES bs_versao ( id )
         ON DELETE CASCADE
);

CREATE TABLE bs_espec_desempenho (
   versao_id        NUMBER PRIMARY KEY,
   aceleracao_0_100 NUMBER(4,1), -- Ex: 5.8
   velocidade_max   NUMBER(4), -- Ex: 180
   modos_conducao   VARCHAR2(255),
   CONSTRAINT fk_desemp_versao FOREIGN KEY ( versao_id )
      REFERENCES bs_versao ( id )
         ON DELETE CASCADE
);

CREATE TABLE bs_espec_dimensao (
   versao_id        NUMBER PRIMARY KEY,
   comprimento_mm   NUMBER,
   largura_mm       NUMBER,
   altura_mm        NUMBER,
   entre_eixos_mm   NUMBER,
   peso_kg          NUMBER,
   capacidade_carga VARCHAR2(100),
   CONSTRAINT fk_dimens_versao FOREIGN KEY ( versao_id )
      REFERENCES bs_versao ( id )
         ON DELETE CASCADE
);

-- ==========================================
-- 3. EQUIPAMENTOS (Checklists com ícones azuis)
-- ==========================================

CREATE TABLE bs_categoria_equip (
   id   NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   nome VARCHAR2(50) NOT NULL -- 'Segurança', 'Conforto', 'Tecnologia'
);

CREATE TABLE bs_equipamento (
   id           NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   categoria_id NUMBER NOT NULL,
   descricao    VARCHAR2(150) NOT NULL, -- Ex: 'Assistente de permanência em faixa'
   CONSTRAINT fk_equip_categ FOREIGN KEY ( categoria_id )
      REFERENCES bs_categoria_equip ( id )
);

CREATE TABLE bs_versao_equipamento (
   versao_id      NUMBER NOT NULL,
   equipamento_id NUMBER NOT NULL,
   PRIMARY KEY ( versao_id,
                 equipamento_id ),
   CONSTRAINT fk_ve_versao FOREIGN KEY ( versao_id )
      REFERENCES bs_versao ( id )
         ON DELETE CASCADE,
   CONSTRAINT fk_ve_equip FOREIGN KEY ( equipamento_id )
      REFERENCES bs_equipamento ( id )
         ON DELETE CASCADE
);

-- ==========================================
-- 4. MÍDIA E FOTOS
-- ==========================================

CREATE TABLE bs_foto_veiculo (
   id          NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   versao_id   NUMBER NOT NULL,
   url_foto    VARCHAR2(500) NOT NULL,
   is_principal NUMBER(1) DEFAULT 0, -- 1 para a foto de capa, 0 para galeria
   CONSTRAINT fk_foto_versao FOREIGN KEY ( versao_id )
      REFERENCES bs_versao ( id )
         ON DELETE CASCADE
);