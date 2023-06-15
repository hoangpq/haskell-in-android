# should be run on termux with ghc installed
ghc -O2 -dynamic -shared -fPIC -o libFoo.so Foo.hs stufft.c -lHSrts-ghc9.2.5