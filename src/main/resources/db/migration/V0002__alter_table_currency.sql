ALTER TABLE currency ALTER COLUMN createdat SET DEFAULT NOW();
ALTER TABLE currency ALTER COLUMN "name" SET NOT NULL;
ALTER TABLE currency ALTER COLUMN code SET NOT NULL;
