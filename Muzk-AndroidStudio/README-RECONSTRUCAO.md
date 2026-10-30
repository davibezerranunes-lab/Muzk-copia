# Muzk — projeto Android reconstruído

Este projeto é uma **base de reconstrução** gerada a partir do APK enviado e da saída do JADX.

## O que foi incluído
- Fontes reconstruídos em `app/src/main/java/com/muzk/app`
- Recursos Android em `app/src/main/res`
- Manifesto recuperado
- Bibliotecas nativas recuperadas em `app/src/main/jniLibs`
- Configuração inicial do Gradle/Android Studio

## Limitações importantes
- O JADX converteu bytecode DEX em Java aproximado; não recuperou o Kotlin original.
- A configuração Gradle e as versões das dependências são uma reconstrução inicial, não o projeto original.
- O código pode exigir correções de compilação, recursos ausentes e dependências adicionais.
- Os binários nativos foram copiados, mas podem depender de componentes/arquivos que não estão neste ZIP.
- Não foi possível declarar o aplicativo funcional sem compilar e testar em um dispositivo.

## Abrir
1. Extraia o ZIP.
2. Abra a pasta `Muzk-AndroidStudio` no Android Studio.
3. Aguarde o Gradle sincronizar.
4. Tente compilar o módulo `app`.
5. Anote e envie o primeiro erro de compilação para corrigirmos em sequência.

Min SDK 26 (Android 8.0), conforme manifesto recuperado. Package: `com.muzk.app`.
