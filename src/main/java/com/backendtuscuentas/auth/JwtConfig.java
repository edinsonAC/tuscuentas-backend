package com.backendtuscuentas.auth;

public class JwtConfig {
//laves generadas con OpenSSL
	// public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEAziOSCh7cvDHKushlp6Zu8uVCPJUUH5MoPQxPd2ahCk3aEIs7\r\n"
			+ "KsuGU1swSL6mUDMklXarBeuK80jftvOonMLyRHrPg0GgDOnCwkrgsYDq3w2P1tDz\r\n"
			+ "/Qz78iFpx5Se1cZv3wDtWOEnptmytWnbm44CDrsnMJLYqECWV8X4ZSGCM/SLh1Vu\r\n"
			+ "IiY3V+DMb0RZ5cMuvXNFBn+OqGo430iCT/BWSYlG9lq9ToKjMzBGCG0U4Riy5b2x\r\n"
			+ "Yw2/DYBrtQsedHe2rmTzOmeF3FKNYkeMsv25Qad972oHxO149yvYIjM3oGSFn1uU\r\n"
			+ "K94knnV2xGE7280C8B7x0W+sH4KWm0k9wS2bpwIDAQABAoIBAC0vwu2RAlYGnCgB\r\n"
			+ "kbcEVsHL248oJrcdLO7k6e6EgrydgDWsL5Yb8yAGlzj7Ab4G1/gjgS3VCip2SQPz\r\n"
			+ "uXxTh4PXX/GnywvJmjW48DQ4zEOE14kBWNqZpAjZpjRnscGutAswStb21BhRFEmM\r\n"
			+ "IOWiZXURNXACYJfRQKOQ8/hHNiFpDu0GIyoSaY8Xr/LQ+OsURriWET0GaeFDAlXd\r\n"
			+ "8BPH7dRPM/6g1xjZ8lpvBVnYh40oowamuNmxWlou+FSswuZhrdoZsW1br4f3akxH\r\n"
			+ "9Ip1aZnUkGRWAD/LQtCi9/a5XfWeykvFD7hlJj/iDYx2iKYnw8TNXs0szCU6QCix\r\n"
			+ "6N2/rvECgYEA8bNQS7jYk2S0Q26Jg+IIkvG5a0mvNxgXd3v1MV4heAS1s5gHPhD6\r\n"
			+ "8sKEvAOgcoo/mGP2u8SSEwm4n9zUbL7aPvsy0fxhQE4YCp0aBQFLGxoH9UDHzqLO\r\n"
			+ "0iLtcvGn/qT5jt1mEB4Thc7Gk58hTXtQHCEgTqA0NWTIH8FTBjSxpSsCgYEA2lWo\r\n"
			+ "igMhvSfvJSGk/luYXMT53NGZFZm3X5zX01rx8dSvgLtd1mKKhNiSKuGEpxW7IJQQ\r\n"
			+ "mZcH4LLRsee7rGoVkbiMxSFr75lLrzflxc6H9LyzfPnu8e3GE38RleECCH6YHvMC\r\n"
			+ "v0v3ny9VsPSivYCpxflr2Dbn+Nl6d16BLxu13XUCgYEA43fsg7ctLFpERIoNJW9e\r\n"
			+ "vlx8MnqgSeuEelDQy2tZeEiGcMUNW95DLqDepsuK/wEZJOQ/Wyt+hihJ9zmvOcDM\r\n"
			+ "SSXECFfLdueIPMTprfgvpQv0nV4gLVqP5rg0XE8N2duNemTnHxgPK4kU3e2PPApn\r\n"
			+ "tHGApD6lo/J7XVdmOZrx7Q0CgYBVGxKpSXM7Unerl6PC6l1HvBhRdPohK1wJTw/p\r\n"
			+ "+QdaZrdKjL6VNLAd/HVtdZ7JqnTYzB50YCTX95w5psTG/ksOFEv7A34ZVT3lPPq5\r\n"
			+ "0jm4sl2cl6gGcdLGAsAOFjk+qmoNllg5zRjm2gKjCZjuGVsUKpdZHn3pyIwuP45H\r\n"
			+ "mJuZiQKBgFF7C/TFDES/YwOEBk4scDsS9UPVv8iM9Kcb7TEsGGeHk4kKG2C7dlpW\r\n"
			+ "8zIbibiYScwu4EPO7stsJvOWywdBuC5nqBskkxJBGS/OIhlFeHNwyIy+HELW4iTf\r\n"
			+ "g5yIM3xuRQnZ0EArlk+z/bL1GF8wzIwPB+kYg0PUJUemJ51JqFIY\r\n" + "-----END RSA PRIVATE KEY-----";

	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAziOSCh7cvDHKushlp6Zu\r\n"
			+ "8uVCPJUUH5MoPQxPd2ahCk3aEIs7KsuGU1swSL6mUDMklXarBeuK80jftvOonMLy\r\n"
			+ "RHrPg0GgDOnCwkrgsYDq3w2P1tDz/Qz78iFpx5Se1cZv3wDtWOEnptmytWnbm44C\r\n"
			+ "DrsnMJLYqECWV8X4ZSGCM/SLh1VuIiY3V+DMb0RZ5cMuvXNFBn+OqGo430iCT/BW\r\n"
			+ "SYlG9lq9ToKjMzBGCG0U4Riy5b2xYw2/DYBrtQsedHe2rmTzOmeF3FKNYkeMsv25\r\n"
			+ "Qad972oHxO149yvYIjM3oGSFn1uUK94knnV2xGE7280C8B7x0W+sH4KWm0k9wS2b\r\n" + "pwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
