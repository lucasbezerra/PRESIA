select unidade_saude.cod_cnes, unidade_saude.nome_fantasia, profissional_v.cod_cns, profissional_v.nome
from us_profissional
inner join profissional_v on us_profissional.id_profissional = profissional_v.id_pessoa
inner join unidade_saude on us_profissional.id_unidade_saude = unidade_saude.id_unidade_saude
where unidade_saude.cod_cnes in ('6638066','6789889','8800816','6831587')

