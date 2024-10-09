package lk.ijse.fruitshop.fruitshop.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteErrorResponse implements NoteResponse, Serializable {
    private int errorcode;
    private String errormessage;
}
