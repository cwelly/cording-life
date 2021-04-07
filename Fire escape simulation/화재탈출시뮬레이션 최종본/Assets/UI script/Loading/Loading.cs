using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class Loading : MonoBehaviour {
    [SerializeField] public Text enableText;
    public Text curload;
    public Image LoadingBar;
    private float Load;
    private float MaxLoad;
    private string lastdam;
    private float s_x;
    private float s_y;
    private float s_z;
    private float ratio = 0;
    private bool startenable;
    public GameObject sound;
    void Start()
    {
        enableText.enabled = false;
        s_x = LoadingBar.rectTransform.localScale.x;
        s_y = LoadingBar.rectTransform.localScale.y;
        s_z = LoadingBar.rectTransform.localScale.z;
        Load = 0;
        MaxLoad = 100;
        ratio = 0;
        startenable = false;
    }
    void Update()
    {
        if (Load < 100)
        {
            Load += Time.deltaTime*20;
        }
        else if (Load >= 100) {
            Load = 100;
            startenable = true;
            enableText.enabled = true;
            sound.SendMessage("enableSound");
        }
        ratio = Load / MaxLoad;
        curload.text = (int)Load + "%";
        LoadingBar.rectTransform.localScale = new Vector3(ratio * s_x, s_y, s_z);
        if (startenable) {
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space)) {
                SceneManager.LoadScene("Game");
            }
        }
    }
}
