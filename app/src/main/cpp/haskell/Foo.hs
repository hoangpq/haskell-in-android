import Foreign.C as C 
import Data.Text as T
import Data.Text.Foreign as T

foreign export ccall len :: CString -> IO CInt
len t = C.peekCString t >>= return . CInt . fromIntegral . T.length . T.pack  
main = return ()
