-- ==========================================
-- 1. NÚCLEO DO VEÍCULO
-- ==========================================

CREATE TABLE bs_marca (
   id_marca   NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   nome_marca VARCHAR2(100) NOT NULL,
   url_logo   VARCHAR2(255)
);

CREATE TABLE bs_modelo (
   id_modelo   NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   id_marca    NUMBER NOT NULL,
   nome_modelo VARCHAR2(100) NOT NULL,
   CONSTRAINT fk_modelo_marca FOREIGN KEY ( id_marca )
      REFERENCES bs_marca ( id_marca )
);

CREATE TABLE bs_versao (
   id_versao      NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   id_modelo      NUMBER NOT NULL,
   nome_versao    VARCHAR2(150) NOT NULL, -- Ex: "Raptor V6 3.0"
   ano_fabricacao NUMBER(4) NOT NULL,
   ano_modelo     NUMBER(4) NOT NULL,
   preco_atual    NUMBER(12,2), -- Ex: 466500.00
   nota_media     NUMBER(3,2) DEFAULT 0, -- Ex: 4.80
   qtd_avaliacoes NUMBER DEFAULT 0,
   CONSTRAINT fk_versao_modelo FOREIGN KEY ( id_modelo )
      REFERENCES bs_modelo ( id_modelo )
);

-- ==========================================
-- 2. ESPECIFICAÇÕES (Cards Expansíveis)
-- ==========================================

CREATE TABLE bs_espec_motor (
   id_versao       NUMBER PRIMARY KEY,
   tipo_motor      VARCHAR2(100), -- Ex: V6 3.0L Bi-Turbo EcoBoost
   potencia_cv     NUMBER(5,1),
   torque_kgfm     NUMBER(5,1),
   combustivel     VARCHAR2(50),
   valvulas        NUMBER(2),
   consumo_cidade  VARCHAR2(50),
   consumo_estrada VARCHAR2(50),
   CONSTRAINT fk_motor_versao FOREIGN KEY ( id_versao )
      REFERENCES bs_versao ( id_versao )
         ON DELETE CASCADE
);

CREATE TABLE bs_espec_transmissao (
   id_versao        NUMBER PRIMARY KEY,
   tipo_transmissao VARCHAR2(50), -- Automática, Manual
   marchas          NUMBER(2),
   tracao           VARCHAR2(50), -- 4x4, AWD, FWD
   diferencial      VARCHAR2(150),
   CONSTRAINT fk_trans_versao FOREIGN KEY ( id_versao )
      REFERENCES bs_versao ( id_versao )
         ON DELETE CASCADE
);

CREATE TABLE bs_espec_desempenho (
   id_versao        NUMBER PRIMARY KEY,
   aceleracao_0_100 NUMBER(4,1), -- Ex: 5.8
   velocidade_max   NUMBER(4), -- Ex: 180
   modos_conducao   VARCHAR2(255),
   CONSTRAINT fk_desemp_versao FOREIGN KEY ( id_versao )
      REFERENCES bs_versao ( id_versao )
         ON DELETE CASCADE
);

CREATE TABLE bs_espec_dimensao (
   id_versao        NUMBER PRIMARY KEY,
   comprimento_mm   NUMBER,
   largura_mm       NUMBER,
   altura_mm        NUMBER,
   entre_eixos_mm   NUMBER,
   peso_kg          NUMBER,
   capacidade_carga VARCHAR2(100),
   CONSTRAINT fk_dimens_versao FOREIGN KEY ( id_versao )
      REFERENCES bs_versao ( id_versao )
         ON DELETE CASCADE
);

-- ==========================================
-- 3. EQUIPAMENTOS (Checklists com ícones azuis)
-- ==========================================

CREATE TABLE bs_categoria_equip (
   id_categoria   NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   nome_categoria VARCHAR2(50) NOT NULL -- 'Segurança', 'Conforto', 'Tecnologia'
);

CREATE TABLE bs_equipamento (
   id_equipamento NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   id_categoria   NUMBER NOT NULL,
   descricao      VARCHAR2(150) NOT NULL, -- Ex: 'Assistente de permanência em faixa'
   CONSTRAINT fk_equip_categ FOREIGN KEY ( id_categoria )
      REFERENCES bs_categoria_equip ( id_categoria )
);

CREATE TABLE bs_versao_equipamento (
   id_versao      NUMBER NOT NULL,
   id_equipamento NUMBER NOT NULL,
   PRIMARY KEY ( id_versao,
                 id_equipamento ),
   CONSTRAINT fk_ve_versao FOREIGN KEY ( id_versao )
      REFERENCES bs_versao ( id_versao )
         ON DELETE CASCADE,
   CONSTRAINT fk_ve_equip FOREIGN KEY ( id_equipamento )
      REFERENCES bs_equipamento ( id_equipamento )
         ON DELETE CASCADE
);

-- ==========================================
-- 4. MÍDIA E FOTOS
-- ==========================================

CREATE TABLE bs_foto_veiculo (
   id_foto      NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   id_versao    NUMBER NOT NULL,
   url_foto     VARCHAR2(500) NOT NULL,
   is_principal NUMBER(1) DEFAULT 0, -- 1 para a foto de capa, 0 para galeria
   CONSTRAINT fk_foto_versao FOREIGN KEY ( id_versao )
      REFERENCES bs_versao ( id_versao )
         ON DELETE CASCADE
);