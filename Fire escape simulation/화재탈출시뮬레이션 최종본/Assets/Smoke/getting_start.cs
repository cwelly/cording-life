using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class getting_start : MonoBehaviour {
    [SerializeField] public Text smoke_text;
    [SerializeField] public Image im_nar;
    public GameObject sound1;
    public GameObject sound2;
    public GameObject MainGameManager;

    private bool textenable = false;
    private float waittime = 3;

    public GameObject enable_space;
    // Use this for initialization
    void Start () {
        im_nar.enabled = false;
        smoke_text.enabled = false;
    }
	
	// Update is called once per frame
	void Update () {
        if (textenable)
        {
            waittime -= Time.deltaTime;
            im_nar.enabled = true;
            smoke_text.enabled = true;
            if (waittime < 0)
            {
                sound1.SendMessage("disableSound");
                sound2.SendMessage("enableSound");
                im_nar.enabled = false;
                smoke_text.enabled = false;
                MainGameManager.SendMessage("EnableDamaging");
                Destroy(enable_space);
            }
        }
    }
    private void OnTriggerEnter(Collider col)
    {
        if (col.tag == "Player")
        {
            textenable = true;
        }
    }
}
