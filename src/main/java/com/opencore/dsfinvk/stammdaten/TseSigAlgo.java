package com.opencore.dsfinvk.stammdaten;

public enum TseSigAlgo {

  ECDSA_PLAIN_SHA224("ecdsa-plain-SHA224"),
  ECDSA_PLAIN_SHA256("ecdsa-plain-SHA256"),
  ECDSA_PLAIN_SHA384("ecdsa-plain-SHA384"),
  ECDSA_PLAIN_SHA512("ecdsa-plain-SHA512"),
  ECDSA_PLAIN_SHA3_224("ecdsa-plain-SHA3-224"),
  ECDSA_PLAIN_SHA3_256("ecdsa-plain-SHA3-256"),
  ECDSA_PLAIN_SHA3_384("ecdsa-plain-SHA3-384"),
  ECDSA_PLAIN_SHA3_512("ecdsa-plain-SHA3-512"),
  ECSDSA_PLAIN_SHA224("ecsdsa-plain-SHA224"),
  ECSDSA_PLAIN_SHA256("ecsdsa-plain-SHA256"),
  ECSDSA_PLAIN_SHA384("ecsdsa-plain-SHA384"),
  ECSDSA_PLAIN_SHA512("ecsdsa-plain-SHA512"),
  ECSDSA_PLAIN_SHA3_224("ecsdsa-plain-SHA3-224"),
  ECSDSA_PLAIN_SHA3_256("ecsdsa-plain-SHA3-256"),
  ECSDSA_PLAIN_SHA3_384("ecsdsa-plain-SHA3-384"),
  ECSDSA_PLAIN_SHA3_512("ecsdsa-plain-SHA3-512");

  private final String bsiName;

  TseSigAlgo(String bsiName) {
    this.bsiName = bsiName;
  }
}
