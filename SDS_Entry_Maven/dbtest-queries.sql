1)SELECT SUM(claimed_charge) FROM document where status = "EXPORTED";




2)   SELECT d.insured_name, d.insured_address, d.claimed_charge
     FROM document d
     join batch c ON d.batch_id = c.customer_id
     where d.status = 'TO_REPRICE'
     and c.customer_id in (1, 2);